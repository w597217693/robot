package com.bigcat.app.dto;

import lombok.Data;

import java.util.Map;

@Data
public class BetsOrderItemDto {
    private String name;
    private Integer money;
    private Object data;
    private String playerIn;
}
