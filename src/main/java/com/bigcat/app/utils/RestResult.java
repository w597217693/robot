package com.bigcat.app.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class RestResult {

    private Integer status;
    private String msg;
    private Object data;

    public static final Integer CLIENT_EXCEPTION = 400;
    public static final Integer SERVER_EXCEPTION = 500;
    public static final Integer REQUEST_EXCEPTION = 402;
    public static final Integer REQUEST_SUCCESS = 200;

    public RestResult(){

    }

    public RestResult (Integer status , String msg , Map<String,Object> data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public RestResult (Integer status , String msg){
        this.status = status;
        this.msg = msg;

    }

    public RestResult put(String key, Object value){
        Map<String,Object> map = (Map<String,Object>) data;
        map.put(key,value);
        return this;
    }
    public RestResult add(List value){
        List<Object> array = (List<Object>) data;
        array.addAll(value);
        return this;
    }

    public RestResult add(Object value){
        List<Object> array = (List<Object>) data;
        array.add(value);
        return this;
    }
    public RestResult map(){
        this.data = new LinkedHashMap<>();
        return this;
    }
    public RestResult array(){
        this.data = new ArrayList<>();
        return this;
    }


    public static RestResult build(){
        return new RestResult(REQUEST_SUCCESS,"成功");
    }



    public static RestResult ok(Map<String,Object> data){
        return new RestResult(REQUEST_SUCCESS,"成功",data);
    }

    public static RestResult cli(String msg){
        return new RestResult(CLIENT_EXCEPTION,msg,null);
    }

    public static RestResult sev(String msg){
        return new RestResult(CLIENT_EXCEPTION,msg,null);
    }
}

