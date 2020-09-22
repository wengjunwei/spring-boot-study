package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/show")
	public String show(){
		System.out.println("hello heihei sdsd dd====sds");
		return "index";
	}
	
}
