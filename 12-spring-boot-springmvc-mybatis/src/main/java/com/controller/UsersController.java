package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Users;
import com.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
	
	/**
	 * 添加用户
	 */
	@RequestMapping("/addUser")
	public String addUser(Users users){
		this.usersService.addUser(users);
		return "ok";
	}
	
	/**
	 * 用户展示
	 * 
	 */
	@RequestMapping("/showUsers")
	public String showUsers(Model model){
		List<Users> list=this.usersService.findAllUsers();
		model.addAttribute("list",list);
		System.out.println(list);
		return "/showUsers";		
	}
	
	
	/**
	 * 根据用户id查询用户
	 */
	@RequestMapping("/findUsersById")
	public String findUsersById(Integer id,Model model){
		Users user = usersService.findUsersById(id);
		model.addAttribute("user",user);
		return "update";
	}
	
	/**
	 * 修改用户信息
	 */
	@RequestMapping("/editUsers")
	public String editUsers(Users users){
		this.usersService.updateUsers(users);
		return "ok";
	}
	
	/**
	 *删除用户 
	 */
	@RequestMapping("/deleteUsers")
	public String deleteUsers(Integer id){
		this.usersService.deleteUsers(id);
		return "redirect:/users/showUsers";
	}
}
