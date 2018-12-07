package com.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.HouseUserMapper;
import com.pojo.User;
import com.service.HouseUserService;
@Service
public class HouseUserServiceImpl implements HouseUserService {
	@Autowired
	private HouseUserMapper houseMapper;

	@Override
	public User login(@Param("userName") String userName, @Param("passWord") String passWord) {
		return houseMapper.login(userName, passWord);
	}

	@Override
	public int exists(String name) {
		int num=-1;
		try {
			num=houseMapper.exists(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int register(User user) {
		int num=-1;
		try {
			num=houseMapper.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public User getUserId(String name) {
		return houseMapper.getUserId(name);
	}
}
