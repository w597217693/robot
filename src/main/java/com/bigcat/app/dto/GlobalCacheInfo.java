package com.bigcat.app.dto;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class GlobalCacheInfo {

    // 登陆的用户信息
    private User user;
    // 进行的是那一个游戏
    private String gameId;
    // 1=开始游戏  -1||null 停止游戏
    private Integer gameIng;
    // 游戏进行到了那个阶段：1=未封盘 -1=已封盘
    private Integer gameStage;
    // 当前期号
    private Long period;
    // 下期期号
    private Long nextPeriod;
    // 下期开奖时间
    private Date nextTime;
    // 开奖结果
    private List<Integer> results;
    // 倒计时时间
    private Long second;

    private static Map<String,Object> cache = new ConcurrentHashMap<>();

    static{
        GlobalCacheInfo globalCacheInfo = new GlobalCacheInfo();
        User u = new User();
        u.setGameId("547247ba-6108-11ea-8c24-0242ac110002");
        u.setToken("123456");
        u.setUsername("test");
        u.setExpireTime(new Date((System.currentTimeMillis() + 1000 * 60 * 24 * 5)));
        globalCacheInfo.setUser(u);
        globalCacheInfo.setGameId("547247ba-6108-11ea-8c24-0242ac110002");
        cache.put("CacheInfo",globalCacheInfo);
    }

    public static void put(String key , Object value){
        if(!StringUtils.equals(key,"CacheInfo")){
            cache.put(key,value);
        }
    }
    public static Object get(String key){
        return cache.get(key);
    }

    public static GlobalCacheInfo getInfo(){
        return (GlobalCacheInfo) get("CacheInfo");
    }

}
