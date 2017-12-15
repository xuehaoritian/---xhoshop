package com.shop.product.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Product;
import com.shop.product.service.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Resource
	private ProductServiceImpl productServiceImpl;
	
	@RequestMapping(value="/productDisplay",method=RequestMethod.GET)
	public	String productDisplay(Model model) {
		List<Product> list=this.productServiceImpl.selectAll();
		 model.addAttribute("productList",list);
		return "products";
		
	}
	@RequestMapping(value="/displayByType",method=RequestMethod.GET)
	public String productDisplayByType(Model model,@RequestParam("type") String type) {
		System.out.println("this is controller");
		List<Product> list=this.productServiceImpl.selectByType(type);
		model.addAttribute("typeProductList",list);
		return "productClassification";	
	}
	@RequestMapping(value="/productDisplayByKeyword",method=RequestMethod.GET)
	public String productDisplayByKeyword(Model model,@RequestParam("search") String key) {
		List<Product> list = this.productServiceImpl.selectByKey(key);
		model.addAttribute("keyProductList",list);
		return "productKeyword";
		
	}
}
