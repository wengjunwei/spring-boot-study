package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	
	@RequestMapping("/{page}")
	public String showMsg(@PathVariable String page,String id){
		System.out.println(id);
		return page;
	}
	
	
	
}
