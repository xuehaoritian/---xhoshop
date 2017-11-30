package com.shop.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.User;
import com.shop.user.dao.UserDaoImpl;
@Service
@Transactional(readOnly=true)
public class UserServiceImpl {
	@Resource
	private UserDaoImpl userDaoImpl;
	public User selectAll() {
		
		User u = this.userDaoImpl.findAll();
		return u;
		
	}
}
