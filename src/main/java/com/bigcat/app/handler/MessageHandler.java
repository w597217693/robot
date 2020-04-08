package com.bigcat.app.handler;

import com.alibaba.fastjson.JSONObject;
import com.bigcat.app.anno.RequestMessage;
import com.bigcat.app.dao.FinanceMapper;
import com.bigcat.app.dao.PlayerMapper;
import com.bigcat.app.dto.*;
import com.bigcat.app.handler.mssage.dto.ScoreDto;
import com.bigcat.app.pojo.*;
import com.bigcat.app.service.impl.BetsOrderService;
import com.bigcat.app.service.impl.FinanceService;
import com.bigcat.app.service.impl.PlayerService;
import com.bigcat.app.service.impl.TemplateService;
import com.bigcat.app.socket.exception.ClientException;
import com.bigcat.app.utils.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
public class MessageHandler {

    public TemplateService getTemplateService(){
        return AppUtils.support.getTemplateService();
    }
    public PlayerMapper getPlayerMapper(){
        return AppUtils.support.getPlayerMapper();
    }
    public FinanceService getFinanceService(){
        return AppUtils.support.getFinanceService();
    }
    public BetsOrderService getBetsOrderService(){
        return AppUtils.support.getBetsOrderService();
    }
    public FinanceMapper getFinanceMapper(){
        return AppUtils.support.getFinanceMapper();
    }
    public PlayerService getPlayerService(){
        return AppUtils.support.getPlayerService();
    }

    /**
     * 查询开奖历史
     * @return
     */
    @RequestMessage(Path = "/message/lottery-record")
    public Object lotteryRecord(ScoreDto dto , Player player){
        return "Hello World";
    }


    /**
     * 取消订单
     * @return
     */
    @RequestMessage(Path = "/message/order-cancel")
    public Object orderCancel(ScoreDto dto , Player player){
        TemplateResponse response = new TemplateResponse();
        Flag flag = getTemplateService().flag("");
        boolean cancelOrderInvalid = false;
        if(flag.isOpen()){
            Integer value = flag.getValue();
            Long second = GlobalCacheInfo.getInfo().getSecond();

            if(second != null && second > value){


                BetsOrderExample example = new BetsOrderExample();
                example.createCriteria().andPlayerIdEqualTo(player.getId())
                                        .andPeriodEqualTo(GlobalCacheInfo.getInfo().getNextPeriod());

                List<BetsOrder> orders = AppUtils.support.getBetsOrderMapper().selectByExample(example);

                BigDecimal money = orders.stream().map(e -> {
                    BetsOrderExample orderExample = new BetsOrderExample();
                    orderExample.createCriteria().andIdEqualTo(e.getId());
                    AppUtils.support.getBetsOrderMapper().deleteByExample(orderExample);
                    AppUtils.support.getFinanceMapper().deleteByPrimaryKey(e.getFinanceId());
                    return e.getBetsMoney().abs();
                }).reduce((x, y) -> x.add(y)).get();
                player.setBalance(player.getBalance().add(money));
                getPlayerMapper().updateByPrimaryKeySelective(player);
            }else{
                cancelOrderInvalid = true;
            }
        }else{
            cancelOrderInvalid = true;
        }

        if(cancelOrderInvalid){
            Template template = getTemplateService().buildTemplate(ConstantUtils.CANCEL_ORDER_INVALID_TEMPLATE, player);
            response.setTemplate(template);
            throw new ClientException("订单取消无效",response);
        }

        return null;
    }


    /**
     * 下分审核
     * @return
     */
    @RequestMessage(Path = "/message/lower-score")
    public Object messageLowerScore(ScoreDto dto , Player player){
        return lowerOrUpperScore(player,new BigDecimal(dto.getMoney()),
                ConstantUtils.FinanceType.LowerScore.index,ConstantUtils.LOWER_SCORE_SETTINGS);
    }

    /**
     * 上分审核
     * @return
     */
    @RequestMessage(Path = "/message/upper-score")
    public Object messageUpperScore(ScoreDto dto , Player player){
        return lowerOrUpperScore(player,new BigDecimal(dto.getMoney()),
                ConstantUtils.FinanceType.UpperScore.index,ConstantUtils.UPPER_SCORE_SETTINGS);
    }

    // 重复上下分提示
    private boolean repeatUpperAndLowerTips(BigDecimal money,Player player,Integer financeType){

        Flag flag = getTemplateService().flag(ConstantUtils.REPEAT_UPPER_AND_LOWER);
        if(flag.isOpen()){
            Date now = new Date();
            Date date = new Date(now.getTime()-(flag.getDefer() * 1000));
            FinanceExample example = new FinanceExample();
            example.createCriteria().andPlayerIdEqualTo(player.getId())
                                    .andCreateTimeBetween(date,now)
                                    .andTypeEqualTo(financeType)
                                    .andMoneyEqualTo(money)
                                    .andStatusEqualTo(ConstantUtils.FinanceStatus.NotExamine.index);

            List<Finance> finances = getFinanceMapper().selectByExample(example);
            if(finances!=null && finances.size()>0){

                return true;
            }
        }

        return false;
    }

    private Object lowerOrUpperScore(Player player,BigDecimal money, Integer financeType,String settingsId){

        TemplateResponse response = new TemplateResponse();
        response.setSource(player.getSource());

        // 判断是否重复上下分
        if(repeatUpperAndLowerTips(money, player, financeType)){
            Template template = getTemplateService()
                    .buildTemplate(ConstantUtils.REPEAT_UPPER_AND_LOWER_TIPS, player);
            response.setTemplate(template);

            throw new ClientException("["+player.getNickname()+"]重复"+ ConstantUtils.FinanceType.getName(financeType),response);
        }

        /*
            下分判断余额逻辑
             如果money = 0 || null 那么就是下所有的分
             如果money != 0 || null 那么就是下指定分数的分
        */
        if(financeType.equals(ConstantUtils.FinanceType.LowerScore.index)){
            if(money != null && !money.equals(0)){
                if(player.getBalance().compareTo(money) == -1){
                    Template template = getTemplateService().buildTemplate(ConstantUtils.BALANCE_SHORT_OF, player);
                    response.setTemplate(template);

                    throw new ClientException("余额不足",response);
                }
            }else{
                money = player.getBalance();
            }
        }

        // 添加上分记录
        Finance finance = getFinanceService().add(financeType,player,
                ConstantUtils.FinanceStatus.NotExamine.index,money);

        // 组建上下分成功返回
        Map<String, String> data = new HashMap<>();
        data.put("{上下分}", ConstantUtils.FinanceType.getName(financeType));
        data.put("{金额}",finance.getMoney().toString());

        Template template = getTemplateService().buildTemplate(settingsId, player, data);
        response.setTemplate(template);

        // 判断是否带语音
        Flag isVoice = getTemplateService().flag(ConstantUtils.IS_YU_YING);

        response.getOther().put("financeId",finance.getId());
        response.getOther().put("money",AppUtils.support.getTemplateService().formatMoney(finance.getMoney()));
        response.getOther().put("voice",isVoice.isOpen());

        return response;

    }

    /**
     * 查流水
     * @return
     */
    @RequestMessage(Path = "/message/query-bill")
    public Object queryBill(MessageBaseDto dto , Player player){

        TemplateResponse response = new TemplateResponse();

        Settings settings = AppUtils.getSettings(ConstantUtils.RESET_TIME);
        JSONObject object = JSONObject.parseObject(settings.getTemplateText());

        String shi = object.getString("shi");
        String fen = object.getString("fen");
        String miao = object.getString("miao");

        Date date = DateUtils.toYMdHms(shi, fen, miao);

        BetsOrderExample example = new BetsOrderExample();
        example.createCriteria().andStatusEqualTo(ConstantUtils.BetsOrderStatus.Settled.index)
                                .andCreateTimeBetween(date,DateUtils.now())
                                .andPlayerIdEqualTo(player.getId());
        List<BetsOrder> orders = AppUtils.support.getBetsOrderMapper().selectByExample(example);

        BigDecimal liushui = orders.stream().map(e -> e.getBetsMoney().abs()).reduce((x, y) -> x.add(y)).get();
        BigDecimal yinkui = orders.stream().map(e -> {
            Finance finance = AppUtils.support.getFinanceMapper().selectByPrimaryKey(e.getResultFinanceId());
            return finance.getMoney().subtract(e.getBetsMoney().abs());
        }).reduce((x, y) -> x.add(y)).get();


        Map<String,String> data = new HashMap<>();
        data.put("{今日流水}",liushui.toString());
        data.put("{今日盈亏}",yinkui.toString());

        Template template = getTemplateService().buildTemplate(ConstantUtils.QUERY_LIU_SHUI_TEMPLATE, player, data);
        response.setTemplate(template);

        return response;
    }


    /**
     * 查福利
     * @return
     */
    @RequestMessage(Path = "/message/query-welfare")
    public Object queryWelfare(MessageBaseDto dto , Player player){

        return null;
    }

    /**
     * 查分
     * @return
     */
    @RequestMessage(Path = "/message/query-score")
    public Object messageQueryScore(MessageBaseDto dto , Player player){

        TemplateResponse response = new TemplateResponse();
        Template template = getTemplateService().buildTemplate(ConstantUtils.QUERY_SCORE_SETTINGS, player);
        response.setTemplate(template);

        return response;
    }

    /**
     * 玩家回水
     * @return
     */
    @RequestMessage(Path = "/message/rebate")
    public Object messageRebate(MessageBaseDto dto , Player player){

        Flag open = getTemplateService().flag("63E2DF81-9217-4229-9459-A192D6C4BD2A");

        TemplateResponse response = new TemplateResponse();

        if(open.isOpen()){

        }else {
            Template template = new Template();
            template.setStatus(ConstantUtils.SettingsStatus.Close.index);
            response.setTemplate(template);
            throw new ClientException("暂无回水",response);
        }
        return "success";
    }

    /**
     * 下注
     * @return
     */
    @RequestMessage(Path = "/message/order-bets")
    public Object messageOrderBets(BetsOrderDto dto , Player player){

        try{
            TemplateResponse response = getBetsOrderService().betsOrder(player,dto);
            return response;
        }catch (ClientException ex){
            ex.printStackTrace();
            throw ex;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(String[] args) {


        System.out.println(new BigDecimal(12).subtract(new BigDecimal(12).multiply(new BigDecimal(2))));


    }
}























