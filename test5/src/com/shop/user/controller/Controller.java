package com.shop.user.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.entity.User;
import com.shop.user.service.UserServiceImpl;

@org.springframework.stereotype.Controller
@RequestMapping("/user")
public class Controller {
	@Resource
	private UserServiceImpl usi;
	
	@RequestMapping("/u")
	public String selectALLname(Model model, HttpSession session) {
		System.out.println("这是控制器");
		User u = this.usi.selectAll();
		System.out.println(u.getUserName());
		return "index";
		
	}
}
