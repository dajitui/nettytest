package com.dream.springbootframe.config.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * RabbitMQ(AMQP)
 * 接收消息目的地
 */
/*@Component*/
public class GetMsg {

    @RabbitListener(queues = "sendMsg")
    public void printMsg(String msg) {
        System.out.println(msg);
    }
}
