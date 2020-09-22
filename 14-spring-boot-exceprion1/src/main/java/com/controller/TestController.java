package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * SpringBoot处理异常方式一：自定义错误页面
 *
 *
 */
@Controller
public class TestController {
	
	@RequestMapping("/show")
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
