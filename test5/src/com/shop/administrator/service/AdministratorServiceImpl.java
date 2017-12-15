package com.shop.administrator.service;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.administrator.dao.AdministratorDaoImpl;
import com.shop.entity.Administrator;

@Service
@Transactional
public class AdministratorServiceImpl {
	@Resource
	private AdministratorDaoImpl administratorDaoImpl;

	public Administrator login(String arg,String password) {
		Administrator a = this.administratorDaoImpl.findByLogin(arg);
		if(a!=null) {
			if(a.getPassword().equals(password)) {
				return a;
			}else {
				return null;
			}
		}else {
			return null;
		}		
	}
	
}
