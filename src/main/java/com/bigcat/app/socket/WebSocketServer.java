package com.bigcat.app.socket;

import com.alibaba.fastjson.JSONObject;
import com.bigcat.app.anno.GateWay;
import com.bigcat.app.dto.*;
import com.bigcat.app.pojo.Player;
import com.bigcat.app.socket.exception.ClientException;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.ConstantUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.management.relation.RoleUnresolved;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

@ServerEndpoint("/robot/{token}")
@Component
public class WebSocketServer {

    private static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private Session session;



    public static WebSocketServer server;

    @OnOpen
    public void onOpen(Session session , @PathParam("token") String token) throws IOException {
        try{
            User user = GlobalCacheInfo.getInfo().getUser();
            if(user == null)
                throw new RuntimeException("用户未登陆");

            if(StringUtils.isBlank(token) || !StringUtils.equals(token,user.getToken()))
                throw new RuntimeException("token 不正确");


            this.session = session;
            WebSocketServer.server = this;
            // 发送开奖信息
            AppUtils.support.getTemplateService().sendLotteryInfo();
        }catch (Exception e){
            session.getBasicRemote().sendText(e.getMessage());
        }
    }

    @OnClose
    public void onClose(){
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message, Session session){
        Map<String,Object> response = new LinkedHashMap<>();
        try{
            JSONObject obj = null;
            try{
                obj = JSONObject.parseObject(message);
            }catch (Exception e){
                throw new RuntimeException("传递的[message]不是一个json");
            }

            String path = null;
            if(obj.containsKey("path")){
                path = obj.getString("path");
            }else{
                throw new RuntimeException("path 不能为空");
            }

            JSONObject data = null;
            if(obj.containsKey("data")){
                data = obj.getJSONObject("data");
            }else{
                throw new RuntimeException("data 不能为空");
            }

            String account = null;
            if(obj.containsKey("account")){
                account = obj.getString("account");
            }else{
                throw new RuntimeException("account 不能为空");
            }

            String nickname = null;
            if(obj.containsKey("nickname")){
                nickname = obj.getString("nickname");
            }else{
                throw new RuntimeException("nickname 不能为空");
            }

            Integer source = null;
            if(obj.containsKey("source")){
                source = obj.getInteger("source");
            }else{
                throw new RuntimeException("source 不能为空");
            }

            response.put("path",path);

            try {
                // 用户自动注册
                Player player = AppUtils.support.getRegisterFilter().doFilter(account, nickname, source);
                response.put("source",player.getSource());
                response.put("nickname",player.getNickname());
                response.put("account",player.getAccount());

                Object o = ConstantUtils.gateWay.gateWay2(path, data , player);
                response.put("data",o);
                response.put("status",200);

            } catch (InvocationTargetException e) {
                if(e instanceof InvocationTargetException){
                    Throwable targetE = e.getTargetException();
                    if(targetE instanceof ClientException){
                        ClientException exc = (ClientException)targetE;
                        response.put("status",401);
                        response.put("data",exc.getData());
                        response.put("msg",exc.getMessage());

                    }else{
                        throw new RuntimeException(targetE.getMessage());
                    }
                }else{
                    throw new RuntimeException(e.getMessage());
                }
            }
        }catch (Exception e){
            response.put("status",400);
            response.put("msg",e.getMessage());
            e.printStackTrace();
        }

        sendText(JSONObject.toJSONString(response));
    }

    public static void sendText(String msg){
        try {
            if(WebSocketServer.server != null && WebSocketServer.server.session != null &&WebSocketServer.server.session.isOpen()){
                WebSocketServer.server.session.getBasicRemote().sendText(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
