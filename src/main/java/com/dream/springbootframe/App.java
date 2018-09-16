package com.dream.springbootframe;

import com.dream.springbootframe.config.netty.NettyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author Dream
 * 2018年1月31日
 *
 * 
 */
@SpringBootApplication
//开启缓存
@EnableCaching
//开启jpa
@EnableJpaRepositories("com.dream.springbootframe.jpa")
public class App implements CommandLineRunner {

    //JMS activeMQ
    /*@Autowired
    private JmsTemplate jmsTemplate;*/

    //RabbitMQ(AMQP)
    /*@Autowired
    private RabbitTemplate rabbitTemplate;*/

	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    //实现CommandLineRunner 重写run方法 这里放了netty的启动
    @Override
    public void run(String... args) throws Exception {
        new NettyService();

        //JMS activeMQ 发送消息 (目的地, 消息)
        //jmsTemplate.send("sendMsg", new Msg());

        //RabbitMQ(AMQP) 发送消息 (目的地, 消息)
        //rabbitTemplate.convertAndSend("sendMsg", "消息");
    }
}
