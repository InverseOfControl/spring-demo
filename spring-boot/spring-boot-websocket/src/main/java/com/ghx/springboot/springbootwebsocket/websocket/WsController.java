package com.ghx.springboot.springbootwebsocket.websocket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * 客户端使用：
 * 1.连接 endpoint，也就是 WebSocketConfig 中定义的 /endpointChat
 * 2.订阅 destination, /user/queue/notifications 这里多了一个 /user, 说明会给指定用户发送消息
 */
@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if (principal.getName().equals("user1")) {
            simpMessagingTemplate.convertAndSendToUser("user2", "/queue/notifications", principal.getName() + "-send:" + msg);
        }
    }

}
