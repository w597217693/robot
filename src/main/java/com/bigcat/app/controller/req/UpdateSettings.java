package com.bigcat.app.controller.req;

import lombok.Data;

@Data
public class UpdateSettings {
    private String settingsId;
    private Integer status;
    private String templateText;
    private String templateImage;
}
