package com.shop.cart.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.CartProduct;
@Repository
public class CartDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	/*
	 * 添加购物车产品
	 * */
	public void insertProduct(CartProduct cp) {
		//String hql="update CartProduct cp set cp.count ="+cp.getCount()+",cp.userId="+cp.getUserId()+",cp.productId="+cp.getProductId();
		this.sessionFactory.getCurrentSession().save(cp);
	}
	/*
	 * 删除购物车产品
	 * */
	public void deleteProduct(CartProduct cp) {
		this.sessionFactory.getCurrentSession().remove(cp);
	}
	/*
	 * 修改产品数量
	 * */
	public void modifyProduct(CartProduct cp) {
		String hql="update CartProduct cp set cp.count ="+cp.getCount()+" where cp.userId="+cp.getUserId()+" and cp.productId="+cp.getProductId();
		this.sessionFactory.getCurrentSession().createQuery(hql);
	}
	/*
	 * 查询某类产品
	 * return List<CartProduct>
	 * */
	public List<CartProduct> findBy(String hql) {
		List list=null;
		list=this.sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
		
	}
	/*
	 * 查询莫用户购买的某产品
	 * */
	public CartProduct findByIds(int userId,int productId) {
		CartProduct cp = null;
		cp=(CartProduct) this.sessionFactory.getCurrentSession().createQuery("from CartProduct where userId=? and productId=?").setParameter(0, userId).setParameter(1, productId).uniqueResult();
		return cp;
		
	}
}
