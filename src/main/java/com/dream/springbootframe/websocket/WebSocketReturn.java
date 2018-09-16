package com.dream.springbootframe.websocket;

import lombok.Data;

/**
 * 接收广播的实体
 */
@Data
public class WebSocketReturn {

    private String message;
    private String str;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
