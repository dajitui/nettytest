package com.dream.springbootframe.config;

import com.dream.springbootframe.config.netty.NettyService;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket
 */
@Configuration
//开启STOMP协议
@EnableWebSocketMessageBroker
public class MyWebSocket implements WebSocketMessageBrokerConfigurer {

    @Override
    //注册STOMP协议节点 映射的url
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //广播 指定使用SockJS协议
        stompEndpointRegistry.addEndpoint("/broadcast").withSockJS();
    }

    @Override
    //配置消息代理
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //
        registry.enableSimpleBroker("/topic");
    }

    /**
     * 启动Netty 也可以不在App.class内实现CommandLineRunner 重写run方法
     * 在NettyService要重新开一个线程
     */
    /*@Bean*/
    public NettyService initNetty() throws Exception {
        System.out.println("注入----------------------------------");
        return new NettyService();
    }
}
