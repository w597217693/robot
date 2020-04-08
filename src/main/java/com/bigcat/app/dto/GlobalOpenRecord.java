package com.bigcat.app.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GlobalOpenRecord {

    // 游戏id
    private String gameId;
    // 本期期号
    private Long period;
    // 下期期号
    private long nextPeriod;
    // 下期开奖时间
    private Date nextTime;
    // 期号状态
    private Integer status;
    // 本期开奖结果
    private String result;
    // 本期开奖结果的显示效果，为json格式：["大","单","龙"]
    private String resultShow;

}
