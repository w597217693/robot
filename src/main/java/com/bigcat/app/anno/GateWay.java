package com.bigcat.app.anno;

import com.alibaba.fastjson.JSONObject;
import com.bigcat.app.dto.RequestPacket;
import com.bigcat.app.dto.ResponsePacket;
import com.bigcat.app.pojo.Player;
import com.bigcat.app.socket.WebSocketServer;
import com.bigcat.app.socket.exception.ClientException;
import com.bigcat.app.socket.filter.WebSocketFilter;
import com.bigcat.app.utils.AppUtils;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

public class GateWay {

    private static final Logger logger = LoggerFactory.getLogger(GateWay.class);

    public Object gateWay(String methodName, Map<String,Object> map) throws InvocationTargetException{
        Object obj = new Object();
        Reflections reflections = new Reflections("com.bigcat.app.handler");//包名且不可忘记，不然扫描全部项目包，包括引用的jar
        //获取带Service注解的类
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Service.class);
        for (Class clazz : typesAnnotatedWith
        ) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods
            ) {
                //判断带自定义注解MyAnnontation的method
                if (method.isAnnotationPresent(RequestMessage.class)) {
                    RequestMessage annotation = method.getAnnotation(RequestMessage.class);
                    //根据入参WayCode比较method注解上的WayCode,两者值相同才执行该method
                    if (null != annotation.Path() && annotation.Path().equals(methodName)) {
                        logger.info("Path = " + annotation.Path());
                        try{
                            obj = method.invoke(clazz.newInstance(), map);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return obj;
    }

    public Object gateWay2(String methodName, JSONObject jsonObject , Player player) throws InvocationTargetException{
        Object obj = new Object();
        Reflections reflections = new Reflections("com.bigcat.app.handler");//包名且不可忘记，不然扫描全部项目包，包括引用的jar
        //获取带Service注解的类
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Service.class);
        boolean flag = true;
        for (Class clazz : typesAnnotatedWith) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods
            ) {
                //判断带自定义注解MyAnnontation的method
                if (method.isAnnotationPresent(RequestMessage.class)) {
                    RequestMessage annotation = method.getAnnotation(RequestMessage.class);
                    //根据入参WayCode比较method注解上的WayCode,两者值相同才执行该method
                    if (null != annotation.Path() && annotation.Path().equals(methodName)) {
                        try{
                            flag = true;

                            Type[] types = method.getGenericParameterTypes();
                            Class<?> aClass = Class.forName(types[0].getTypeName());
                            obj = method.invoke(clazz.newInstance(),JSONObject.toJavaObject(jsonObject, aClass),player);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        if(!flag)
            throw new RuntimeException("没有对应的path");

        return obj;
    }

}