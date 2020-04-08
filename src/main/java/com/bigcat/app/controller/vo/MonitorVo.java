package com.bigcat.app.controller.vo;

import lombok.Data;

@Data
public class MonitorVo {
    // 玩家QQ号
    private String playerId;
    // 玩家昵称
    private String nickname;
    // 余额
    private String balance;
    // 下注金额
    private String betsOrderMoney;
    // 下注内容
    private String betsOrderContent;
    // 上期盈亏
    private String previousProfitAndLoss;
    // 回水

}
