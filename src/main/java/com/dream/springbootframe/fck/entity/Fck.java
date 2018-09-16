package com.dream.springbootframe.fck.entity;

/**
 * @Author: Dream
 * 2018/4/7
 *
 * 富文本实体
 */
public class Fck {

    private String id;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Fck(String text) {
        this.text = text;
    }

    public Fck() {
    }
}
