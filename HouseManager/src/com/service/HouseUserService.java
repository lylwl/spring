package com.service;

import org.apache.ibatis.annotations.Param;

import com.pojo.User;

public interface HouseUserService {
	/**
	 * 登录
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public User login(@Param("userName") String userName, @Param("passWord") String passWord);
	/**
	 * 根据用户名判断是否存在
	 * @param name
	 * @return
	 */
	public int exists(String name);
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public int register(User user);
	/**
	 * 查询当前用户的id
	 * @param id
	 * @return
	 */
	public User getUserId(String name);
}
