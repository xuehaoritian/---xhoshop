package com.shop.administrator.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.Administrator;
@Repository
public class AdministratorDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public Administrator findByLogin(String name) {
		String hql="from Administrator a where a.administratorName='"+name+"'";
		Administrator a=(Administrator) this.sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		return a;
	}
}
