package com.shop.user.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.User;

@Repository
public class UserDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public User findAll() {
		User u = this.sessionFactory.getCurrentSession().get(User.class,"UserId");
		return u;
		
	}
}
