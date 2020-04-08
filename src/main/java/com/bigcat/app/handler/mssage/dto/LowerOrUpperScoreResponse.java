package com.bigcat.app.handler.mssage.dto;

import lombok.Data;

@Data
public class LowerOrUpperScoreResponse {

    // 财务id
    private String financeId;
    private String value;
    private String type;
    private Integer voice;
    private String money;
    private String nickname;
    private String id;
    private Integer toGroup;
}
