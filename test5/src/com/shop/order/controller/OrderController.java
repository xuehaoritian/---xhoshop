package com.shop.order.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.cart.service.CartServiceImpl;
import com.shop.entity.CartProduct;
import com.shop.entity.Order;
import com.shop.entity.User;
import com.shop.order.service.OrderServiceImpl;
import com.shop.product.service.ProductServiceImpl;
@Controller
@RequestMapping("/order")
public class OrderController {
	@Resource
	private OrderServiceImpl orderServiceImpl;
	@Resource
	private CartServiceImpl cartServiceImpl;
	@Resource
	private ProductServiceImpl productServiceImpl;
	@RequestMapping(value="/generateOrder")
	public String generateOrder(Model model,HttpSession session) {
		User u =(User) session.getAttribute("loginingUser");
		List<CartProduct> clist=this.cartServiceImpl.selectCartProduct(u.getUserId());
		int money=0;
		for(int i=0;i<clist.size();i++) {
			money=money+clist.get(i).getCount()*clist.get(i).getPrice();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=df.format(new Date());
		System.out.println(date);
		Order o = new Order();
		
		o.setTotal(money);
		o.setState("未支付");
		o.setDate(date);
		//设置关联关系
		//u.getOset().add(o);
		this.orderServiceImpl.generateOrder(o);
		return "order";
		
	}
}
