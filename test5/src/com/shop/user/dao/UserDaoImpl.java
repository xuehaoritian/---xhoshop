package com.shop.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.SystemPropertyUtils;

import com.shop.entity.User;
@Repository
public class UserDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	/*参数 User
	 * 增加一个User
	 * */
	public void addUser(User u) {
		this.sessionFactory.getCurrentSession().save(u);
	}
	public void deleteUser(User u) {
		System.out.println("delete u dao");
		this.sessionFactory.getCurrentSession().remove(u);
	}
	/*
	 * 条件查询user
	 * 查询一个User
	 * return User
	 * */
	public User findByKeyWord(String arg) {
		User u=(User) this.sessionFactory.getCurrentSession().createQuery(arg).uniqueResult();
		return u;
		
	}
	/*
	 * 按条件查询userlist
	 * return List<User>
	 * */
	public  List<User> findByKeywords(String arg){
		List<User> list = null;
		list = this.sessionFactory.getCurrentSession().createQuery(arg).list();
		return list;
		
	}
	/*
	 * 查询所有User
	 * return List<User>
	 * */
	public List<User> findAll(){
		List<User> list = null;
		list = this.sessionFactory.getCurrentSession().createQuery("select u from User u").list();
		return list;
		
	}
	
	public void updateUser(User u) {
		String hql="update User u set u.userName=?,u.password=?,u.mailAddress=?,u.personalProfile=? where u.userId=?";
		this.sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, u.getUserName()).setParameter(1, u.getPassword()).setParameter(2, u.getMailAddress()).setParameter(3, u.getPersonalProfile()).setParameter(4, u.getUserId()).executeUpdate();
	}
	
}
