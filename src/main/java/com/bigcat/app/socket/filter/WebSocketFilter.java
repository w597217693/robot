package com.bigcat.app.socket.filter;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface WebSocketFilter {
    void doFilter(JSONObject obj);
}
