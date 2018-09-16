package com.dream.springbootframe.fck.dao;

import com.dream.springbootframe.fck.entity.Fck;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author: Dream
 * 2018/4/7
 */
@Mapper
public interface FckDao {

    /**
     * 增
     * @param fck
     */
    @Insert("insert into fck(id, text) values(uuid(), #{text})")
    void add(Fck fck);

    /**
     * 改
     * @param fck
     */
    @Update("update fck set text = #{text} where id = #{id}")
    void update(Fck fck);

    /**
     * 查全部id
     * @return
     */
    @Select("select id from fck")
    List<String> getAllId();

    /**
     * 根据id获取fck
     * @param id
     * @return
     */
    @Select("select id, text from fck where id = #{id}")
    Fck getFckbyId(String id);
}
