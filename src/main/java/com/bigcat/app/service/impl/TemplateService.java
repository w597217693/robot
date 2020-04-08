package com.bigcat.app.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bigcat.app.dao.*;
import com.bigcat.app.dto.*;
import com.bigcat.app.handler.GameResult;
import com.bigcat.app.handler.SSCCalculation;
import com.bigcat.app.pojo.*;
import com.bigcat.app.socket.WebSocketServer;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.ConstantUtils;
import com.bigcat.app.utils.GlobalUtils;
import gui.ava.html.Html2Image;
import gui.ava.html.renderer.ImageRenderer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class TemplateService {

    @Autowired
    private BetsOrderService orderService;

    @Autowired
    private FinanceMapper financeMapper;

    @Autowired
    private FinanceService financeService;

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private SettingsMapper settingsMapper;

    @Autowired
    private ImageService imageService;
    @Autowired
    private BetsOrderMapper orderMapper;
    @Autowired
    private WayMapper wayMapper;
    @Autowired
    private SSCCalculation calculation;

    /**
     * 构建模板：文字型的html字符串转文字模板/图片模板
     * @param settingsId 模板id
     * @param sup
     * @param fun
     * @return
     */
    public Template buildTemplate(String settingsId, Supplier<Object> sup, BiFunction<Object,String,String> fun){
        Settings settings = settingsMapper.selectByPrimaryKey(settingsId);
        return buildTemplate(settings,sup,fun);
    }

    /**
     * 构建模板：文字型的html字符串转文字模板/图片模板
     * @param sup
     * @param fun
     * @return
     */
    public Template buildTemplate(Settings settings, Supplier<Object> sup, BiFunction<Object,String,String> fun){

        Template template = new Template();

        Integer status = settings.getStatus();
        template.setStatus(status);

        if(status.equals(ConstantUtils.SettingsStatus.Close.index))
            return template;

        String templateText = settings.getTemplateText();
        if(status.equals(ConstantUtils.SettingsStatus.OpenImage)){
            String at = fun.apply(sup.get(), templateText.substring(11));
            template.setAt(at);
        }

        templateText = fun.apply(sup.get(), templateText);

        if(status.equals(ConstantUtils.SettingsStatus.OpenImage.index)){
            templateText = html2Base64(templateText);
        }

        template.setValue(templateText);
        if(status.equals(ConstantUtils.SettingsStatus.OpenImage.index)){
            template.setType("base64");
        }else{
            template.setType("text");
        }

        return template;
    }


    public Template buildTemplate(Settings settings,Player player){
        return buildTemplate(settings,()->buildTemplateDefaultMap(player),(obj,template)->defaultBuildTemplate((Map<String,String>)obj,template));
    }
    public Template buildTemplate(String settingsId,Player player){
        return buildTemplate(settingsId,()->buildTemplateDefaultMap(player),(obj,template)->defaultBuildTemplate((Map<String,String>)obj,template));
    }
    public Template buildTemplate(String settingsId,Player player,Map<String,String> data){
        return buildTemplate(settingsId,()->buildTemplateDefaultMap(data,player),(obj,template)->defaultBuildTemplate((Map<String,String>)obj,template));
    }

    public Map<String,String> buildTemplateDefaultMap(Player player){
        return buildTemplateDefaultMap(new HashMap<>(),player);
    }


    public Map<String,String> buildTemplateDefaultMap(Map<String,String> data,Player player){
        if(player != null){
            data.put("{昵称}",player.getNickname());
            data.put("{余分}",player.getBalance().toString());
            data.put("{QQ}",player.getAccount());
        }
        return data;
    }

    /**
     * 默认组建模板方法
     * @param data
     * @param template
     * @return
     */
    public String defaultBuildTemplate(Map<String,String> data,String template){

        StringBuffer sb = new StringBuffer(template);
        List<String> strs = Arrays.asList("{金额}", "{余分}", "{分数}", "{操作金额}", "{总分}","{盈亏}","{总下单额}");

        data.forEach((key,value) -> {
            if(template.contains(key)){

                // 输出与钱相关的时，判断是否保留小数
                if(StringUtils.isBlank(value)){
                    value = "";
                }
                if(strs.contains(key))
                    value = AppUtils.support.getTemplateService().formatMoney(value);

                int start = sb.indexOf(key);
                int end = start + key.length();
                sb.replace(start,end,value);
            }
        });
        return sb.toString().replace(ConstantUtils.LINE_FEED,"\n");
    }

    public List<String> getImageTemplate(String link,Long countDown){
        // 发送开始攻击消息
        SettingsExample example = new SettingsExample();
        example.createCriteria().andDescriptionLike(link);
        List<Settings> list = settingsMapper.selectByExample(example);
        List<String> images = list.stream()
                .filter(ele -> ele.getStatus().equals(ConstantUtils.SettingsStatus.OpenText.index) && ele.getTemplateImage() != null)
                .filter(ele->{
                    if(countDown != null){
                        return !ele.getExecuteDefer().equals(-1)?ele.getExecuteDefer().equals(countDown)?true:false:true;
                    }
                    return true;
                })
                .map(ele -> ele.getTemplateImage()).collect(Collectors.toList());
        return images;
    }

    public void sendCountDownImage(Long second){
        List<String> images = getImageTemplate("CountDownImage" + "%",second);

        images.stream().forEach(ele->{
            String base64 = imageService.imageToBase64(ele);
            TemplateResponse response = new TemplateResponse();
            Template template = new Template();
            template.setValue(base64);
            template.setType("base64");
            template.setStatus(1);
            response.setTemplate(template);
            AppUtils.write(response,"/CountDown/image",200);
        });
    }

    public List<Settings> sendCountDownText(Long second){
        // 发送开始攻击消息
        SettingsExample example = new SettingsExample();
        example.createCriteria().andDescriptionLike("CountDownText%");
        List<Settings> list = settingsMapper.selectByExample(example);
        List<Settings> collect = list.stream().filter(ele -> {
            if (ele.getStatus().equals(ConstantUtils.SettingsStatus.OpenText.index)) {
                if (!ele.getExecuteDefer().equals(-1)) {
                    if (ele.getExecuteDefer().intValue() == second.intValue()) {
                        return true;
                    }
                }
            }
            return false;
        }).collect(Collectors.toList());

        collect.stream().forEach(ele->{
            TemplateResponse response = new TemplateResponse();
            Template template = buildTemplate(ele, null);
            response.setTemplate(template);
            AppUtils.write(response,"/CountDown/text",200);
        });

        return collect;


    }

    public void sendLotteryInfo(){
        try{
            Map<String,String> data = new HashMap<>();

            Long period = GlobalCacheInfo.getInfo().getPeriod();
            Date nextTime = GlobalCacheInfo.getInfo().getNextTime();
            List<Integer> results = GlobalCacheInfo.getInfo().getResults();
            String result = "";
            for (Integer num : results) {
                result+=num;
            }

            int sum = AppUtils.support.getUtils().resultSum(result).intValue();


            String lonHu = "";
            GameResult lon = calculation.lon(sum, results);
            GameResult hu = calculation.hu(sum,results);
            if(lon.isWin()){
                lonHu = "龙";
            }else if(hu.isWin()){
                lonHu = "虎";
            }else{
                lonHu = "合";
            }

            String danShuang = "";
            GameResult dan = calculation.dan(sum);
            GameResult shuang = calculation.shuang(sum);
            if(dan.isWin()){
                danShuang = "单";
            }else if(shuang.isWin()){
                danShuang = "双";
            }

            String daXiao = "";
            GameResult da = calculation.da(sum);
            GameResult xiao = calculation.xiao(sum);
            if(da.isWin()){
                daXiao = "大";
            }else if(xiao.isWin()){
                daXiao = "小";
            }else {
                daXiao = "和";
            }
            result +=("="+results.stream().reduce((x,y)->x+y).get());
            result +="("+lonHu+" "+daXiao+" "+danShuang+")";
            data.put("result",result);
            data.put("lottery","上期开奖("+period+")");
            data.put("nextTime","本期开奖时间:" + GlobalUtils.format.format(nextTime));

            Map<String,Object> response = new HashMap<>();
            response.put("path","/lottery/info");
            response.put("data",data);
            WebSocketServer.sendText(JSONObject.toJSONString(response));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 中奖名单
     * @return
     */
    public TemplateResponse  getBillTemplate(String playerId,String gameId,Long period){
        TemplateResponse response = new TemplateResponse();

        StringBuffer sb = new StringBuffer();

        Settings settings = AppUtils.getSettings(ConstantUtils.WIN_BILL);

        JSONArray array = JSONArray.parseArray(settings.getTemplateText());
        String header = array.getString(0);
        String body = array.getString(1);
        String foot = array.getString(2);

        sb.append(header+ConstantUtils.LINE_FEED);


        List<WinTemplateBean> winBillBody = financeMapper.getWinBillBody(gameId, period);
        Map<String, List<WinTemplateBean>> map = winBillBody.stream().collect(Collectors.groupingBy(WinTemplateBean::getPlayerId));
        map.forEach((key,value)->{
            String str = "";
            String nickname = "";
            for(WinTemplateBean it : value){
                str +=it.getPlayerIn()+"="+it.getWinMoney()+" ";
                if(StringUtils.isBlank(nickname)){
                    nickname = it.getNickname();
                }
            }
            Map<String,String> data = new HashMap<>();
            data.put("{中奖信息}",str);
            data.put("{昵称}",nickname);
            sb.append(defaultBuildTemplate(buildTemplateDefaultMap(data,null), body)+"\r\n");
        });

        sb.append(foot);

        settings.setTemplateText(sb.toString());
        Template template = buildTemplate(settings, null);

        response.setTemplate(template);
        if(StringUtils.isNotBlank(playerId)){
            Player player = AppUtils.getPlayer(playerId);
            response.setSource(player.getSource());
        }
        return response;
    }

    public TemplateResponse getPlayerBill(long period , String gameId,String playerId){

        TemplateResponse response = new TemplateResponse();
        StringBuffer sb = new StringBuffer();

        Settings settings = AppUtils.getSettings(ConstantUtils.BILL_FORMAT);

        JSONArray array = JSONArray.parseArray(settings.getTemplateText());
        String header = array.getString(0);
        String body = array.getString(1);
        String foot = array.getString(2);

        PlayerExample example = new PlayerExample();
        List<Player> players = playerMapper.selectByExample(example);


        Optional<BigDecimal> totalMoney = players.stream().map(ele -> {
            List<BetsOrder> orders = orderService.findByPlayer(ele.getId(), period, gameId);

            BigDecimal money = null;
            if (orders != null) {
                money = orders.stream().map(item -> financeService.calculationProfitAndLoss(item)).reduce((x, y) -> x.add(y)).get();
            }else{
                money = new BigDecimal(0);
            }
            Map<String, String> data = new HashMap<>();
            data.put("{盈亏}", money.toString());
            String bodyTemp = defaultBuildTemplate(buildTemplateDefaultMap(data, ele), body);
            sb.append(bodyTemp + ConstantUtils.LINE_FEED);
            return ele.getBalance();
        }).reduce((x, y) -> x.add(y));

        Map<String,String> data = new HashMap<>();
        data.put("{总分}",totalMoney.get().toString());
        data.put("{人数}",players.size()+"");
        String headerTemp = defaultBuildTemplate(data, header);
        sb.insert(0,headerTemp+ConstantUtils.LINE_FEED);
        sb.append(foot);

        settings.setTemplateText(sb.toString());
        Template template = buildTemplate(settings, null);

        response.setTemplate(template);
        if(StringUtils.isNotBlank(playerId)){
            Player player = AppUtils.getPlayer(playerId);
            response.setSource(player.getSource());
        }
        return response;
    }

    /**
     * 获取攻击核对模板
     * @param period
     * @param gameId
     * @param playerId
     * @return
     */
    public TemplateResponse getBetsCheckTemplate(long period , String gameId , String playerId){


        Settings settings = AppUtils.getSettings(ConstantUtils.STOP_BETS_CHECK);

        JSONArray array = JSONArray.parseArray(settings.getTemplateText());
        String header = array.getString(0);
        String body = array.getString(1);
        String foot = array.getString(2);

        BetsOrderExample example = new BetsOrderExample();
        example.createCriteria().andPeriodEqualTo(period)
                                .andGameIdEqualTo(gameId);
                                //.andStatusEqualTo(ConstantUtils.BetsOrderStatus.NotSettled.index);

        List<BetsOrder> orders = orderMapper.selectByExample(example);
        // 总下单额
        BigDecimal totalMoney = new BigDecimal(0);
        if(orders.size() != 0){
            totalMoney = orders.stream().map(ele -> ele.getBetsMoney().abs()).reduce((x, y) -> x.add(y)).get();
        }


        Map<String, List<BetsOrder>> map = orders.stream().collect(Collectors.groupingBy(BetsOrder::getPlayerId));
        // 下单人数
        Integer totalNum = map.keySet().size();

        Map<String,String> data = new HashMap<>();
        data.put("{总下单额}",totalMoney.toString());
        data.put("{下单人数}",totalNum+"");

        StringBuffer sb = new StringBuffer();
        sb.append(defaultBuildTemplate(data, header) + ConstantUtils.LINE_FEED);

        map.forEach((id,list)->{
            Player player = AppUtils.getPlayer(id);

            String xiadan = "";
            for(BetsOrder order : list){
                BigDecimal money = order.getBetsMoney().abs();
                xiadan += order.getPlayerIn();
            }
            Map<String,String> d = new HashMap<>();
            d.put("{下单}",xiadan);
            sb.append(defaultBuildTemplate(buildTemplateDefaultMap(d,player),body)+ConstantUtils.LINE_FEED);
        });
        sb.append(foot);

        settings.setTemplateText(sb.toString());
        Template template = buildTemplate(settings, null);

        TemplateResponse response = new TemplateResponse();
        response.setTemplate(template);
        if(StringUtils.isNotBlank(playerId)){
            Player player = AppUtils.getPlayer(playerId);
            response.setSource(player.getSource());
        }
        return response;
    }



    public Flag flag(String settingsId){
        Settings settings = AppUtils.getSettings(settingsId);
        Flag flag = new Flag();
        if(settings.getStatus().equals(ConstantUtils.SettingsStatus.OpenText.index)){
            flag.setOpen(true);
            String value = settings.getTemplateText();
            try{
                flag.setValue(Integer.parseInt(value));
            }catch (Exception e){
            }
            flag.setDefer(settings.getExecuteDefer());
        }
        else {
            flag.setOpen(false);
        }
        return flag;
    }


    public String formatMoney(Object value){
        Flag flag = AppUtils.support.getTemplateService()
                .flag(ConstantUtils.MONEY_FORMAT);

        DecimalFormat df2 =new DecimalFormat("#.00");

        if(flag.isOpen()){
            DecimalFormat df = null;
            if(ConstantUtils.BalanceFormat.Integer.index.equals(flag.getValue())){
                df =new DecimalFormat("#");

            }else{
                df =new DecimalFormat("#.00");
            }

            return df.format(new BigDecimal(value.toString()));
        }
        return value.toString();
    }


    private String html2Base64(String html){
        try{
            Map<String, String> map = new HashMap<>();
            map.put("\n","</br>");
            ImageRenderer renderer = Html2Image.fromHtml(html, map).getImageRenderer();
            renderer.setWidth(200);
            BufferedImage bufferedImage = renderer.getBufferedImage();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage,"png",baos);

            byte[] bytes = baos.toByteArray();//转换成字节
            BASE64Encoder encoder = new BASE64Encoder();
            String png_base64 = encoder.encodeBuffer(bytes).trim();//转换成base64串
            png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n

            System.out.println("data:image/png;base64,"+png_base64);
            return png_base64;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
