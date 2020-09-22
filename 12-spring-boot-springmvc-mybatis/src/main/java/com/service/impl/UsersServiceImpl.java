package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.UsersMapper;
import com.pojo.Users;
import com.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public void addUser(Users users) {
		this.usersMapper.insertUser(users);
	}

	@Override
	public List<Users> findAllUsers() {
		return this.usersMapper.selectAll();
	}

	@Override
	public Users findUsersById(Integer id) {
		return this.usersMapper.selectUsersById(id);
	}

	@Override
	public void updateUsers(Users users) {
		this.usersMapper.updateUsers(users);
	}

	@Override
	public void deleteUsers(Integer id) {
		this.usersMapper.deleteUsersById(id);
	}
	
}
