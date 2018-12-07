package com.cssl.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cssl.dao.UserDao;
import com.cssl.pojo.Users;
import com.cssl.service.UserService;
@Service("")
public class UserServiceImpl implements UserService {

	//@Autowired//先根据类型找，如果有相同类型，抛出异常
	//@Qualifier("oracleUS")
	@Resource(name="oracleUS")
	private UserDao ud;
	
	
	/*public UserDao getUd() {
		return ud;
	}


	public void setUd(UserDao ud) {
		this.ud = ud;
	}*/


	@Override
	public int addUser(Users user) {
		System.out.println("这是业务逻辑层·····添加用户");
		
		return ud.addUser(user);
	}

}
