package com.bigcat.app.utils;

import com.bigcat.app.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cache {
    private final Map<String,Object> data = new HashMap<>();

    public Cache(){
        // TODO 测试时,使用默认的用户,正式上线时一定要关闭
        UserDTO user = new UserDTO();
        user.setUsername("BigCat");
        user.setToken("e70376f0-e7cd-4bc0-87b1-2378c4f92a86");
        user.setGameId("547247ba-6108-11ea-8c24-0242ac110002");
        put(ConstantUtils.CACHE_USER,user);
    }

    public void put(String key , Object value){
        data.put(key,value);
    }

    public Object get(String key){
        return data.get(key);
    }
}
