package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pojo.HouseStreet;
import com.pojo.User;
import com.service.HouseListService;
import com.service.HouseUserService;
import com.service.impl.HouseListServiceImpl;
import com.service.impl.HouseUserServiceImpl;
@RestController
public class AjaxController {
	@Autowired
	private HouseUserService houSer = new HouseUserServiceImpl();
	@Autowired
	private HouseListService listSer=new HouseListServiceImpl();
	/**
	 * 验证用户名是否存在
	 * @param userName
	 * @return
	 */
	@RequestMapping("/isExists")
	public int isExists(String userName) {
		int row=houSer.exists(userName);
		if(row>0) {
			return 0;
		}
		return 1;
	}
	/**
	 * 注册
	 * @param u
	 * @return
	 */
	@RequestMapping("/register")
	public int register(User u) {
		User user=new User(0, u.getUserName(), u.getPassWord(), u.getPhone());
		int row=houSer.register(user);
		if(row>0) {
			return 1;
		}
		return 0;
	}
	/**
	 * 根据区县id查询街道
	 * @param did
	 * @return
	 */
	@RequestMapping("/getStreet")
	public List<HouseStreet> getStreet(String did){
		List<HouseStreet> lisStr=listSer.getStreet(Integer.valueOf(did));
		return lisStr;
	}
	@RequestMapping("/del")
	public int del(int hmid) {
		int row=listSer.deleteById(Integer.valueOf(hmid));
		if(row>0) {
			return 1;
		}
		return 0;
	}
}
