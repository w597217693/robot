package com.bigcat.app.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 中奖名单所需的参数
 */
@Data
public class WinTemplateBean {
    private String playerIn;
    private BigDecimal winMoney;
    private String nickname;
    private String playerId;
}
