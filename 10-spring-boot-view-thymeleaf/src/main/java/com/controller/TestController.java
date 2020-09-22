package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Users;


@Controller
public class TestController {
	
	
	
	@RequestMapping("/show")
	public String showMsg(Model model){
		model.addAttribute("msg","thymeleaf hello");
		model.addAttribute("key",new Date());
		return "index";
	}
	
	/**
	 * if语句的使用
	 * @param model
	 * @return
	 */
	@RequestMapping("/show2")
	public String show2(Model model){
		model.addAttribute("sex", "男");
		model.addAttribute("id", "2");
		return "index2";
	}
	
	/*
	 * 遍历在list中
	 */
	@RequestMapping("/show3")
	public String show3(Model model){
		List<Users> list=new ArrayList<>();
		list.add(new Users(1,"小一",18));
		list.add(new Users(2,"小er",19));
		list.add(new Users(3,"item",20));
		model.addAttribute("list",list);
		return "index3";
	}
	
	
	/**
	 * 在map中遍历
	 * @param model
	 * @return
	 */
	@RequestMapping("/show4")
	public String show4(Model model){
		Map<String,Users> map=new HashMap<>();
		map.put("one", new Users(1,"iwen",18));
		map.put("two", new Users(2,"ime",20));
		map.put("three", new Users(3,"iit",19));
		model.addAttribute("map",map);
		return "index4";
	}
	
	/**
	 * 作用域
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/show5")
	public String show5(HttpServletRequest request,Model model){
		request.setAttribute("req", "httpServletRequest");
		request.getSession().setAttribute("sess", "session");
		request.getSession().getServletContext().setAttribute("app", "application");
		return "index5";
	}
	
	
}
