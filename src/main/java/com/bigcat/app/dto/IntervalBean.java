package com.bigcat.app.dto;

import lombok.Data;

import java.util.Date;

@Data
public class IntervalBean {
    private Integer interval;
    private String currentPeriod;
    private Date currentTime;
    private String currentResult;
    private String nextPeriod;
    private Date nextTime;
}
