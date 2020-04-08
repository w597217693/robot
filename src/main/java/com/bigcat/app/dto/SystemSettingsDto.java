package com.bigcat.app.dto;

import lombok.Data;

@Data
public class SystemSettingsDto {
    private boolean isOpen;
    private Integer value;
    private Integer defer;
}
