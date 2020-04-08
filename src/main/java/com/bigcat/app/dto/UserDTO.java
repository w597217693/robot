package com.bigcat.app.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String token;
    private String username;
    private String gameId;
    private Integer gameStatus;
    private Long currentPeriod;
    private Boolean gameStart = false;
}
