package com.service;

import java.util.List;

import com.pojo.Users;

public interface UsersService {
	void addUser(Users users);
	
	List<Users> findAllUsers();
	
	Users findUsersById(Integer id);
	
	void updateUsers(Users users);
	
	void deleteUsers(Integer id);
	
}
