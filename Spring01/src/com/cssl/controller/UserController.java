package com.cssl.controller;
/**
 * 11
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cssl.pojo.Users;
import com.cssl.service.UserService;
@Controller("usercon")
public class UserController {
	
	//业务逻辑
	@Autowired //根据类型装配
	private UserService  us;
	
	
	
	
	
	/*public void setUs(UserService us) {
		this.us = us;
	}
*/




	public void regUser(Users user) {
		System.out.println("用户注册");
		System.out.println("rs："+(us.addUser(user)>0?"ok":"no"));
		
		
	}

}
