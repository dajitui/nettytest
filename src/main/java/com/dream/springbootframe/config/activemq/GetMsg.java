package com.dream.springbootframe.config.activemq;

/**
 * JMS activeMQ
 * 接收消息目的地
 */
/*@Component*/
public class GetMsg {

    /*@JmsListener(destination = "sendMsg")*/
    public void printMsg(String msg) {
        System.out.println(msg);
    }
}
