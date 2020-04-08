package com.bigcat.app.dto;

import lombok.Data;

@Data
public class ResponsePacket {
    private Integer status;
    private String path;
    private Object data;
    private String msg;

    public ResponsePacket(Integer status,String path){
        this.status = status;
        this.path = path;
    }

    public ResponsePacket(){

    }




}
