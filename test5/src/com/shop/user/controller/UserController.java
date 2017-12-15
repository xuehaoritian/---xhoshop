package com.shop.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.User;
import com.shop.user.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserServiceImpl userServiceImpl;
	@RequestMapping(value="/userLogin",method=RequestMethod.GET)
	public String userLogin(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			Model model, HttpSession session) {
		User u= null;
		u=this.userServiceImpl.login(userName, password);
		if(u!=null) {
			session.setAttribute("loginingUser", u);
			return "index";
		}else {
			model.addAttribute("errorinfoLogin", "您的账号密码不正确！");
			return "login";
		}		
	}
	@RequestMapping(value="/userRegist",method=RequestMethod.GET)
	public String userRegist(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			@RequestParam("mailAddress") String mailAddress,
			Model model) {
		User u =new User();
		u.setMailAddress(mailAddress);
		u.setPassword(password);
		u.setUserName(userName);

		String regist = this.userServiceImpl.regist(u);
		
		if(regist.equals("regist success")) {
			return "index";
		}
		else if(regist.equals("mailaddress already existence")){
			model.addAttribute("errorinfoMailAdderss", "该邮箱已被注册过！");
			return "regist";
		}
		else if(regist.equals("username already existence")){
			model.addAttribute("errorinfoUserName", "用户名已被占用！");
			return "regist";
		}else {
			
			return "regist";
		}
		
		
	}
	/*
	 * 修改信息
	 * */
	@RequestMapping(value="/modifyInformation",method=RequestMethod.GET)
	public String modifyInformation(
			@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			@RequestParam("mailAddress") String mailAddress,
			@RequestParam("personalProfile") String personalProfile,
			Model model,HttpSession session) {
		User user=(User) session.getAttribute("loginingUser");
		user.setUserName(userName);
		user.setPassword(password);
		user.setMailAddress(mailAddress);
		user.setPersonalProfile(personalProfile);
		this.userServiceImpl.modifyUser(user);
		JOptionPane.showMessageDialog(null, "修改成功");
		return "index";
		
	}
}
