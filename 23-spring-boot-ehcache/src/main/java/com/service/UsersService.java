package com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pojo.Users;

public interface UsersService {
	
	List<Users> findUsersAll();
	Users findUsersById(Integer id);
	Page<Users> findUsersByPage(Pageable pageable);
	void saveUsers(Users users);
	
}
