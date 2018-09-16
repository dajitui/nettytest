package com.dream.springbootframe.zsgzdemo.dao;


import com.dream.springbootframe.zsgzdemo.entity.DemoUser;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
@Mapper
public interface DemoUserDao {

	/**
	 * 增
	 */
	@Insert("insert into user(id, name, pwd) values(uuid(), #{name}, #{pwd})")
	int addUser(DemoUser user);
	
	/**
	 * 删
	 */
	@Delete("delete from user where id = #{id}")
	int deleteUser(String id);
	
	/**
	 * 改
	 */
	@Update("update user set name = #{name}, pwd = #{pwd} where id = #{id}")
	int updateUser(DemoUser user);
	
	/**
	 * 查list
	 */
	@Select("select id, name from user")
	List<Map<String, Object>> selectAllUser();
	
	/**
	 * 查find
	 */
	@Select("select id, name from user where id = #{id}")
	DemoUser selectFindOneUserByIdOrName(DemoUser user);

	/**
	 * 登录
	 */
	@Select("select *from user where name = #{name} and pwd = #{pwd}")
	DemoUser selectFindOneUserByNameAndPwd(DemoUser user);
	
}
