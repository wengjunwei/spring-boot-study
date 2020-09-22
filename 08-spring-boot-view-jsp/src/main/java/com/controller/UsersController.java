package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Users;

@Controller
public class UsersController {
	
	@RequestMapping("/showUser")
	public String show(Model model){
		List<Users> list=new ArrayList<>();
		list.add(new Users(1,"张暗示",15));
		list.add(new Users(2,"张2",17));
		list.add(new Users(3,"张示",16));
		model.addAttribute("list", list);
		return "userList";
	}
	
}
