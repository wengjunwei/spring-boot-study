package com.mapper;

import java.util.List;

import com.pojo.Users;

public interface UsersMapper {
	void insertUser(Users users);
	
	List<Users> selectAll();
	
	Users selectUsersById(Integer id);
	
	void updateUsers(Users users);
	
	void deleteUsersById(Integer id);
	
}	
