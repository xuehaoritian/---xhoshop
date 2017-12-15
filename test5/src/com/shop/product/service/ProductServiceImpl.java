package com.shop.product.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.Product;
import com.shop.product.dao.ProductDaoImpl;
@Service
@Transactional
public class ProductServiceImpl {
	
	@Resource
	private ProductDaoImpl productDaoImpl;
	
	public List<Product> selectAll() {		
		return this.productDaoImpl.findAllProduct();
		
	}
	public Product selectById(int id) {
		Product p=this.productDaoImpl.findById(id);
		return p;
		
	}
	public List<Product> selectByType(String type){
		System.out.println("this is service");
		List<Product> list = this.productDaoImpl.findByType(type);
		return list;
		
	}
	public List<Product> selectByKey(String key){
		List<Product> list=this.productDaoImpl.findByKeyword(key);
		return list;
	}
	public void deleteProduct(Product p) {
		this.productDaoImpl.deleteProduct(p);
	}
	public void updateProduct(Product p) {
		this.productDaoImpl.updateProduct(p);
	}
	public void insertProduct(Product p) {
		this.productDaoImpl.insertProduct(p);
	}
}
