package com.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pojo.Users;

public interface UsersRepositoryPagingAndSort extends PagingAndSortingRepository<Users, Integer> {

}
