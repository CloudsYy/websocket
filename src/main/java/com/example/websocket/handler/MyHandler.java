package com.example.websocket.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: websocket
 * @description: websocket控制器(websocket协议是基于tcp的一种新的网络协议，效率高，节约带宽，
 *              在不断轮询服务器数据的时候，head信息量大，有效数据少
 *              支持双工通信而http不可以，它只能由客户端发送到服务器)
 * @author: Cloud
 * @create: 2020/5/7 14:03:00
 */
public class MyHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        Map<String,Object> map = JSONObject.parseObject(payload, HashMap.class);
        System.out.println("====接收到的数据"+map);
        session.sendMessage(new TextMessage("服务器返回接收到的信息," + payload));
    }
}
