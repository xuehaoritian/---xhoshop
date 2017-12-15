package com.shop.order.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.shop.entity.Order;
import com.shop.order.dao.OrderDaoImpl;
@Repository
public class OrderServiceImpl {
	@Resource
	private OrderDaoImpl orderDaoImpl;
	public void generateOrder(Order o) {
		this.orderDaoImpl.insertOrder(o);	
		
	}
}
