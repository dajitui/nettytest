package com.dream.springbootframe.fck.service;

import com.dream.springbootframe.fck.entity.Fck;

import java.util.List;

/**
 * @Author: Dream
 * 2018/4/7
 */
public interface FckService {

    /**
     * 增
     * @param fck
     */
    void add(Fck fck);

    /**
     * 改
     * @param fck
     */
    void update(Fck fck);

    /**
     * 查全部id
     * @return
     */
    List<String> getAllId();

    /**
     * 根据id获取fck
     * @param id
     * @return
     */
    Fck getFckbyId(String id);
}
