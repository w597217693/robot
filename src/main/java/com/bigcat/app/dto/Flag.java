package com.bigcat.app.dto;

import lombok.Data;

@Data
public class Flag {
    private boolean open;
    private Integer value;
    private Integer defer;
}
