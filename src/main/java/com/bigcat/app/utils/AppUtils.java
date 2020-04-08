package com.bigcat.app.utils;

import com.alibaba.fastjson.JSONObject;
import com.bigcat.app.listener.handler.LotteryHandler;
import com.bigcat.app.pojo.*;
import com.bigcat.app.socket.WebSocketServer;
import org.springframework.util.ClassUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AppUtils {
    public static GlobalBeanSupport support = SpringUtils.getBean(GlobalBeanSupport.class);
    public static String getClassPath(){
        return ClassUtils.getDefaultClassLoader().getResource("").getPath();
    }

    public static String getFormatBalance(BigDecimal money){
        return AppUtils.support.getUtils().formatBalance(money);
    }

    public static String getFormatNickname(String nickname){
        return AppUtils.support.getUtils().formatNickname(nickname);
    }

    public static Player getPlayer(String playerId){
        return AppUtils.support.getPlayerMapper().selectByPrimaryKey(playerId);
    }

    public static Settings getSettings(String settingsId){
        return AppUtils.support.getSettingsMapper().selectByPrimaryKey(settingsId);
    }

    public static boolean acceptBets(){
        return AppUtils.support.getLotteryHandlerMap().get(LotteryHandler.handlerName).getAcceptBets();
    }

    public static Finance calculation(Way way, BigDecimal betsMoney,
                                      String result, Player player ,
                                      Integer oddsLoc, String path){
        try{
            Map<String,Object> data = new HashMap<>();
            data.put("way",way);
            data.put("betsMoney",betsMoney);
            data.put("result",result);
            data.put("player",player);
            data.put("oddsLoc",oddsLoc);
            return (Finance) ConstantUtils.gateWay.gateWay(path, data);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("开奖失败");
        }
    }

    public static BetsOrder getOrder(String resultFinanceId){
        BetsOrderExample example = new BetsOrderExample();
        example.createCriteria().andResultFinanceIdEqualTo(resultFinanceId);
        List<BetsOrder> betsOrders = AppUtils.support.getBetsOrderMapper().selectByExample(example);
        if(betsOrders == null || betsOrders.size() == 0){
            return null;
        }
        return betsOrders.get(0);

    }

    public static void write(Object o , String path,int status){
        Map<String,Object> response = new LinkedHashMap<>();
        response.put("path",path);
        response.put("data",o);
        response.put("status",status);
        WebSocketServer.sendText(JSONObject.toJSONString(response));
    }
}
