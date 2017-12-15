package com.shop.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.User;
import com.shop.user.dao.UserDaoImpl;
@Service
@Transactional
public class UserServiceImpl {
	@Resource
	private UserDaoImpl userDaoImpl;
	
	public User selectById(int id) {
		System.out.println("select by id");
		User u=this.userDaoImpl.findByKeyWord("from User u where u.userId="+id);
		return u;
		
	}
	public User login(String arg,String password) {
		User u = this.userDaoImpl.findByKeyWord("from User u where u.userName='"+arg+"'");
		if(u!=null) {
			if(u.getPassword().equals(password)) {
				return u;
			}else {
				return null;
			}
		}else {
			return null;
		}		
	}
	
	public String regist(User u) {
		List<User> list = null;
		list=this.userDaoImpl.findByKeywords("from User u where u.userName='"+u.getUserName()+"'");
		if(list.size()==0) {
			list=this.userDaoImpl.findByKeywords("from User u where u.mailAddress='"+u.getMailAddress()+"'");
			if(list.size()==0) {
				this.userDaoImpl.addUser(u);
				return "regist success";
			}else {
				return "mailaddress already existence";
			}
		}else {
			return "username already existence";
		}
		
	}
	public void modifyUser(User u) {
		this.userDaoImpl.updateUser(u);
	}
	
	public void deleteUser(User u) {
		System.out.println("delete u");
		this.userDaoImpl.deleteUser(u);
	}
	public List<User> selelctAll(){
		List<User> list = this.userDaoImpl.findAll();
		return list;
		
	}
}
