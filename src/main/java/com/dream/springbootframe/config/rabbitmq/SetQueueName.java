package com.dream.springbootframe.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * RabbitMQ(AMQP)
 */
/*@Configuration*/
public class SetQueueName {

    /**
     * 定义队列名
     * @return
     */
    @Bean
    public Queue sendQueueName() {
        return new Queue("sendMsg");
    }
}
