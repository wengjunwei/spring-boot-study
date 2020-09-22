package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UsersDaoImpl;

@Service
public class UsersServiceImpl {
	
	@Autowired
	private UsersDaoImpl UsersDaoImpl;
	
	public void addUsers(){
		this.UsersDaoImpl.saveUser();
	}
	
}
