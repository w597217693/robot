package com.bigcat.app.socket.exception;

import lombok.Data;

@Data
public class AppSocketException extends RuntimeException {
    protected Integer status;
    public AppSocketException(String msg){
        super(msg);
    }
    public AppSocketException(String msg,Integer status){
        super(msg);
        this.status = status;
    }
}
