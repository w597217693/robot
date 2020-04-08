package com.bigcat.app.socket.exception;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Map;

@Data
public class ClientException extends RuntimeException{

    private Object data;

    public ClientException(String message,Object data) {
        super(message);
        this.data = data;
    }


}
