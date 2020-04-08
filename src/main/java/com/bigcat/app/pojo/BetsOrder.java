package com.bigcat.app.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BetsOrder {
    private String id;

    private Date createTime;

    private BigDecimal betsMoney;

    private String targetWay;

    private String playerId;

    private String gameId;

    private Long period;

    private String playerIn;

    private String financeId;

    private Integer status;

    private String resultFinanceId;

    private String data;


}