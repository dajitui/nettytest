package com.dream.springbootframe.config.activemq;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * JMS activeMQ
 * 实现MessageCreator的createMessage
 */
public class Msg implements MessageCreator {

    /**
     * 发送的消息内容
     * @param session
     * @return
     * @throws JMSException
     */
    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("消息");
    }
}
