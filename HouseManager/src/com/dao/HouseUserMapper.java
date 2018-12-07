package com.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pojo.User;
@Repository
public interface HouseUserMapper {
	/**
	 * 登录
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	@Autowired
	public User login(@Param("userName") String userName, @Param("passWord") String passWord);
	/**
	 * 根据用户名判断是否存在
	 * @param name
	 * @return
	 */
	@Autowired
	public int exists(String name);
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@Autowired
	public int register(User user);
	
	/**
	 * 查询当前用户的id
	 * @param id
	 * @return
	 */
	@Autowired
	public User getUserId(String name);

}
