package com.shop.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.cart.service.CartServiceImpl;
import com.shop.entity.CartPK;
import com.shop.entity.CartProduct;
import com.shop.entity.Product;
import com.shop.entity.User;
import com.shop.product.service.ProductServiceImpl;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Resource
	private CartServiceImpl cartServiceImpl;
	@Resource
	private ProductServiceImpl productServiceImpl;
	
	@RequestMapping(value="/addToCart")
	public String addToCart(
			@RequestParam("productId") int productId,Model model,HttpSession session) {
		User u =(User) session.getAttribute("loginingUser");
		Product p=this.productServiceImpl.selectById(productId);
		this.cartServiceImpl.insertProduct(u.getUserId(), p);
		return "index";
		
	}
	@RequestMapping(value="/cartDisplay")
	public String cartDisplay(Model model,HttpSession session) {
		User u =(User) session.getAttribute("loginingUser");
		int money=0;
		List<CartProduct> clist=this.cartServiceImpl.selectCartProduct(u.getUserId());
		for(int i=0;i<clist.size();i++) {
			
			money=money+clist.get(i).getCount()*clist.get(i).getPrice();
		}
		model.addAttribute("money", money);
		model.addAttribute("cartProductList",clist);
		return "cart";
	}
	
	/*
	 * +一个
	 * */
	@RequestMapping(value="/cartAddDisplay")
	public String cartAddDisplay(@RequestParam("productId") int productId,Model model,HttpSession session) {
		User u =(User) session.getAttribute("loginingUser");
		Product p=this.productServiceImpl.selectById(productId);
		this.cartServiceImpl.insertProduct(u.getUserId(), p);
		int money=0;
		List<CartProduct> clist=this.cartServiceImpl.selectCartProduct(u.getUserId());
		for(int i=0;i<clist.size();i++) {
			
			money=money+clist.get(i).getCount()*clist.get(i).getPrice();
		}
		model.addAttribute("money", money);
		model.addAttribute("cartProductList",clist);
		return "cart";
		
	}
	@RequestMapping(value="/cartReduceDisplay")
	public String cartReduceDisplay(@RequestParam("productId") int productId,Model model,HttpSession session) {
		User u =(User) session.getAttribute("loginingUser");
		Product p=this.productServiceImpl.selectById(productId);
		this.cartServiceImpl.deleteProduct(u.getUserId(), p);
		int money=0;
		List<CartProduct> clist=this.cartServiceImpl.selectCartProduct(u.getUserId());
		for(int i=0;i<clist.size();i++) {
			
			money=money+clist.get(i).getCount()*clist.get(i).getPrice();
		}
		model.addAttribute("money", money);
		model.addAttribute("cartProductList",clist);
		return "cart";
		
	}
}
