package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${hello.msg}")
	private String msg;
	
	@RequestMapping("/hello")
	public String showMsg(){
		return msg;
	}
	
}
