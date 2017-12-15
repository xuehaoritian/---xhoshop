package com.shop.administrator.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.shop.administrator.service.AdministratorServiceImpl;
import com.shop.entity.Administrator;
import com.shop.entity.Product;
import com.shop.entity.User;
import com.shop.product.service.ProductServiceImpl;
import com.shop.user.service.UserServiceImpl;


@Controller
@RequestMapping("/administrator")
public class AdministratorController {
	@Resource
	private AdministratorServiceImpl administratorServiceImpl; 
	@Resource
	private UserServiceImpl userServiceImpl;
	@Resource
	private ProductServiceImpl productServiceImpl;
	@RequestMapping(value="/adminLogin",method=RequestMethod.GET)
	public String adminLogin(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			Model model, HttpSession session) {
		Administrator a= null;
		a=this.administratorServiceImpl.login(userName, password);
		if(a!=null) {
			session.setAttribute("admin", a);
			List<User> ulist=this.userServiceImpl.selelctAll();
			List<Product> plist=this.productServiceImpl.selectAll();
			model.addAttribute("productList",plist);
			model.addAttribute("userList",ulist);
			return "admin";
		}else {
			model.addAttribute("adminerrorinfoLogin", "您的账号密码不正确！");
			return "loginadm";
		}		
	}
	@RequestMapping(value="/userDelete")
	public String userDelete(@RequestParam("userId") int userId,Model model) {
		System.out.println(userId);
		User u=this.userServiceImpl.selectById(userId);
		System.out.println(u.getUserId());
		
		this.userServiceImpl.deleteUser(u);
		
		
		List<User> ulist=this.userServiceImpl.selelctAll();
		List<Product> plist=this.productServiceImpl.selectAll();
		model.addAttribute("productList",plist);
		model.addAttribute("userList",ulist);
		return "admin";
		
	}
	@RequestMapping(value="/productDelete")
	public String productDelete(@RequestParam("productId") int productId,Model model) {

		Product p=this.productServiceImpl.selectById(productId);
		
		this.productServiceImpl.deleteProduct(p);
		
		List<User> ulist=this.userServiceImpl.selelctAll();
		List<Product> plist=this.productServiceImpl.selectAll();
		model.addAttribute("productList",plist);
		model.addAttribute("userList",ulist);
		return "admin";
		
	}
	@RequestMapping(value="/productUpdate")
	public String productUpdate(@RequestParam("productId") int productId,Model model) {
		Product p=this.productServiceImpl.selectById(productId);
		model.addAttribute("updateProduct",p);
		return "prod";
		
	}
	@RequestMapping(value="/productAction")
	public String productAction(@RequestParam("productName") String productName,
			@RequestParam("productDescription") String productDescription,
			@RequestParam("price") int price,
			@RequestParam("imgAddress") String imgAddress,
			@RequestParam("shelfTime") String shelfTime,
			@RequestParam("type") String type,Model model) {
		Product p=new Product();
		p.setImgAddress(imgAddress);
		p.setPrice(price);
		p.setProductDescription(productDescription);
		p.setProductName(productName);
		p.setType(type);
		p.setShelfTime(shelfTime);
		
		this.productServiceImpl.updateProduct(p);
		
		List<User> ulist=this.userServiceImpl.selelctAll();
		List<Product> plist=this.productServiceImpl.selectAll();
		model.addAttribute("productList",plist);
		model.addAttribute("userList",ulist);
		return "admin";
		
	}
	

}
