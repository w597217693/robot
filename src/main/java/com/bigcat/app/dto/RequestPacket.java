package com.bigcat.app.dto;

import lombok.Data;

import java.util.Map;

@Data
public class RequestPacket {
    private String path;
    private Map<String,Object> data;
}