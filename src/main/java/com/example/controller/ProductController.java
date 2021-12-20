package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController 
{
	@RequestMapping("/add")
	public String m1()
	{
		return "addproduct";
	}
	
	@RequestMapping("/")
	public String m2()
	{
		return "products";
	}
}

