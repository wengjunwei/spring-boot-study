package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {
	@RequestMapping("/showUsers1")
	public String showMsg(){
		String str=null;
		System.out.println(str.length());
		return "index";
	}
	

	@RequestMapping("/showUsers2")
	public String show2(){
		int a=10/0;
		return "index";
	}
}
