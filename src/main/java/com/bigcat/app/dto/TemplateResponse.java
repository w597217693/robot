package com.bigcat.app.dto;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class TemplateResponse {
    private String msg;
    private Template template = new Template();
    private Map<String,Object> other = new LinkedHashMap<>();
    private Integer source;
}
