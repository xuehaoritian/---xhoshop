package com.shop.cart.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.cart.dao.CartDaoImpl;
import com.shop.entity.CartProduct;
import com.shop.entity.Product;

@Service
@Transactional
public class CartServiceImpl {
	@Resource
	private CartDaoImpl cartDaoImpl;
	
	public void insertProduct(int userId,Product p) {
		CartProduct cp = this.cartDaoImpl.findByIds(userId, p.getProductId());
		if(cp==null) {
			CartProduct cpt = new CartProduct();
			cpt.setUserId(userId);
			cpt.setProductId(p.getProductId());
			cpt.setCount(1);
			cpt.setProductName(p.getProductName());
			cpt.setPrice(p.getPrice());
			this.cartDaoImpl.insertProduct(cpt);
		}else {
			cp.setCount(cp.getCount()+1);
			this.cartDaoImpl.modifyProduct(cp);
		}
	}
	public void deleteProduct(int userId,Product p) {
		CartProduct cp = this.cartDaoImpl.findByIds(userId, p.getProductId());
		if(cp.getCount()>1) {
			cp.setCount(cp.getCount()-1);
			this.cartDaoImpl.modifyProduct(cp);
		}else {
			this.cartDaoImpl.deleteProduct(cp);
		}
		
	}
	public List<CartProduct> selectCartProduct(int userId){
		List<CartProduct> list=this.cartDaoImpl.findBy("from CartProduct where userId="+userId);
		System.out.println("selectCartProduct");
		return list;
		
	}
}
