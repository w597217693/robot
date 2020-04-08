package com.bigcat.app.dto;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String username;
    private Date expireTime;
    private String gameId;
    private String token;
}
