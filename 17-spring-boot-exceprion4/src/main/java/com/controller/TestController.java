package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * SpringBoot处理异常方式二：exceprionHandeler
 *
 *
 */
import org.springframework.web.servlet.ModelAndView;
@Controller
public class TestController {
	
	@RequestMapping("/show1")
	public String showMsg(){
		String str=null;
		System.out.println(str.length());
		return "index";
	}
	
	

	@RequestMapping("/show2")
	public String show2(){
		int a=10/0;
		return "index";
	}
	
	
}
