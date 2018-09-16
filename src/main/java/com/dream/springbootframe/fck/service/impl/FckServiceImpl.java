package com.dream.springbootframe.fck.service.impl;

import com.dream.springbootframe.fck.dao.FckDao;
import com.dream.springbootframe.fck.entity.Fck;
import com.dream.springbootframe.fck.service.FckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Dream
 * 2018/4/7
 */
@Service
@Transactional
public class FckServiceImpl implements FckService {

    @Autowired
    private FckDao fckDao;

    /**
     * 增
     * @param fck
     */
    public void add(Fck fck) {
        fckDao.add(fck);
    }

    /**
     * 改
     * @param fck
     */
    public void update(Fck fck) {
        fckDao.update(fck);
    }

    /**
     * 查全部id
     * @return
     */
    public List<String> getAllId() {
        return fckDao.getAllId();
    }

    /**
     * 根据id获取fck
     * @param id
     * @return
     */
    public Fck getFckbyId(String id) {
        return fckDao.getFckbyId(id);
    }
}
