package com.bigcat.app.listener.handler;

import com.alibaba.fastjson.JSONObject;
import com.bigcat.app.dao.FinanceMapper;
import com.bigcat.app.dao.OpenRecordMapper;
import com.bigcat.app.dao.PlayerMapper;
import com.bigcat.app.dao.SettingsMapper;
import com.bigcat.app.dto.GlobalCacheInfo;
import com.bigcat.app.dto.Template;
import com.bigcat.app.dto.TemplateResponse;
import com.bigcat.app.listener.handler.period.HandlerUtils;
import com.bigcat.app.pojo.*;
import com.bigcat.app.service.impl.BetsOrderService;
import com.bigcat.app.service.impl.ImageService;
import com.bigcat.app.service.impl.OpenRecordService;
import com.bigcat.app.service.impl.TemplateService;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.ConstantUtils;
import com.bigcat.app.utils.GlobalUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class LotteryHandler {

    protected abstract String gameId();
    protected abstract String handlerName();
    protected abstract long stopBetsSecond();
    protected abstract HandlerUtils utils();
    protected abstract String getPath();
    @Autowired
    protected OpenRecordService recordService;
    @Autowired
    protected OpenRecordMapper recordMapper;
    @Autowired
    protected TemplateService templateService;
    @Autowired
    protected BetsOrderService orderService;
    @Autowired
    private FinanceMapper financeMapper;
    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private SettingsMapper settingsMapper;
    @Autowired
    private ImageService imageService;

    protected boolean acceptBets = false;

    public static String handlerName;


    public boolean getAcceptBets(){
        return acceptBets;
    }

    public static String startGame = null;
    public static boolean isStart = false;


    protected void service(OpenRecord record){
        Long period = record.getPeriod();

        // 受理订单
        acceptance(record);

        if(isRun()){
            // 发送开始攻击消息
            List<String> images = templateService.getImageTemplate("StartBetsImage" + "%",null);
            String base64 = imageService.imageToBase64(images.stream().findFirst().get());
            TemplateResponse response = new TemplateResponse();
            Template template = new Template();
            template.setValue(base64);
            template.setType("base64");
            template.setStatus(1);
            response.setTemplate(template);

            AppUtils.write(response,"/start/bets",200);
        }

        // 发送倒计时数据
        long second = getSecond(period);

        acceptBets = true;
        while(true){
            if(second <= stopBetsSecond()){ // 封盘操作
                GlobalCacheInfo.getInfo().setSecond(-1L);
                // 标志已封盘
                if(GlobalCacheInfo.getInfo().getGameStage().equals(1)){
                    GlobalCacheInfo.getInfo().setGameStage(-1);
                }
                if(isRun()){
                    // 发送攻击核对
                    System.out.println("期号---------------------->>"+period);
                    TemplateResponse response = templateService.getBetsCheckTemplate(utils().nextPeriod(period), gameId(), null);
                    AppUtils.write(response,"/bets/check",200);
                }

                // 封盘
                Map<String,String> stopMap = new HashMap<>();
                AppUtils.write(stopMap,"/console/down",200);
                break;
            }else{  //发送读秒
                GlobalCacheInfo.getInfo().setGameStage(1);
                Map<String,String> stopMap = new HashMap<>();
                stopMap.put("data","倒计时:" + second);
                GlobalCacheInfo.getInfo().setSecond(second);
                AppUtils.write(stopMap,"/console/down",200);

                if(isRun()){
                    sendCountDownImg(second);
                    sendCountDownText(second);
                }
            }

            try{
                --second;
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        acceptBets = false;
    }

    /**
     * 发送倒计时图片
     */
    @Async
    public void sendCountDownImg(Long second){
        AppUtils.support.getTemplateService().sendCountDownImage(second);
    }

    /**
     * 发送倒计时文本
     * @param second
     */
    @Async
    public void sendCountDownText(Long second){
        AppUtils.support.getTemplateService().sendCountDownText(second);
    }

    private OpenRecord acceptance(OpenRecord record){
        Long period = record.getPeriod();

        if(StringUtils.isNotBlank(GlobalCacheInfo.getInfo().getGameId()) && StringUtils.equals(GlobalCacheInfo.getInfo().getGameId(),gameId())){
            GlobalCacheInfo.getInfo().setPeriod(period);
            GlobalCacheInfo.getInfo().setNextPeriod(utils().nextPeriod(period));
            GlobalCacheInfo.getInfo().setNextTime(utils().openTime(utils().nextPeriod(period)));
            GlobalCacheInfo.getInfo().setResults(Arrays.stream(record.getResult().split(",")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList()));
        }

        Map<String,String> stopMap = new HashMap<>();
        stopMap.put("data","开奖中");
        AppUtils.write(stopMap,"/console/down",200);

        OpenRecordExample example = new OpenRecordExample();
        example.createCriteria().andPeriodEqualTo(record.getPeriod())
                                .andGameidEqualTo(record.getGameid());
        List<OpenRecord> openRecords = recordMapper.selectByExample(example);

        OpenRecord dbRecord = null;
        if(openRecords!=null && openRecords.size()>0) dbRecord = openRecords.get(0);

        if(dbRecord != null){
            dbRecord.setResult(record.getResult());
            orderService.settlementOrder(record, getPath());

            if(isRun()){
                // 发开奖信息到控制台显示
                templateService.sendLotteryInfo();
                // 发开奖图

                // 发中奖信息

                // 发中奖名单
                TemplateResponse billTemplate =templateService.getBillTemplate(null,gameId(),period);
                System.out.println(billTemplate.getTemplate().getValue());
                AppUtils.write(billTemplate,"/win/bill",200);

                // 发账单
                TemplateResponse playerBill = templateService.getPlayerBill(period, gameId(), null);
                AppUtils.write(playerBill,"/player/bill",200);

                // 发走势图
            }

            if(dbRecord.getStatus().equals(ConstantUtils.OpenRecordStatus.Close.index))
                dbRecord.setStatus(ConstantUtils.OpenRecordStatus.Open.index);


            recordMapper.updateByPrimaryKeySelective(dbRecord);
        }else {
            record.setStatus(ConstantUtils.OpenRecordStatus.Open.index);
            recordMapper.insert(record);
        }
        // 插入下一次的期号记录
        long nextPeriod = utils().nextPeriod(period);
        OpenRecord obj = new OpenRecord();
        obj.setPeriod(nextPeriod);
        obj.setOpenTime(utils().openTime(nextPeriod));
        obj.setResult(null);
        obj.setId(UUID.randomUUID().toString());
        obj.setGameid(gameId());
        obj.setStatus(ConstantUtils.OpenRecordStatus.Close.index);
        recordMapper.insert(obj);

        return record;
    }

    private long getSecond(long period){
        long nextPeriod = utils().nextPeriod(period);
        Date now = new Date();
        Date nextTime = utils().openTime(nextPeriod);

        long time = nextTime.getTime() - now.getTime();
        long second = 0;
        if(time > 0)
            second = time / 1000;

        return second;
    }

    private boolean isRun(){
        Integer gameIng = GlobalCacheInfo.getInfo().getGameIng();

        if(gameIng == null || gameIng.equals(-1))
            return false;

        return true;
    }
}
