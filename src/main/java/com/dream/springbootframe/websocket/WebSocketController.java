package com.dream.springbootframe.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 *
 */
@Controller
@MessageMapping("/socket")
public class WebSocketController {

    //路径映射 如同@RequestMapping
    @MessageMapping("/welconee")
    //当服务端有消息 会向订阅了@SendTo("/topic/get")的发送消息
    @SendTo("/topic/get")
    public WebSocketReturn say(WebSocketReturn wsr) throws Exception {
        System.out.println(wsr.getMessage());
        System.out.println(wsr.getStr());
        return wsr;
    }
}
