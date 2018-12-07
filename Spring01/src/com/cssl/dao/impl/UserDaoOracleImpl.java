package com.cssl.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cssl.dao.BaseDao;
import com.cssl.dao.UserDao;
import com.cssl.pojo.Users;
@Repository("oracleUS")
public class UserDaoOracleImpl implements UserDao {
	@Autowired
	private BaseDao bd;
	
	@Override
	public int addUser(Users user) {
		System.out.println("我是Oracle数据访问层····fsadfgsdgsdg·");
		bd.getSession();
		return user.getId();
	}

}
