package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService  productService;
	
	
	@GetMapping("/between")
	
	public String getProducts(@RequestParam int startPrice,@RequestParam int endPrice,Model model) {
		model.addAttribute("products",productService.getProducts(startPrice, endPrice));
		return "/products/productList";
		
	}

}
