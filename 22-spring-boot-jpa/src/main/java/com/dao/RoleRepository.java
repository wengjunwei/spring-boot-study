package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pojo.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
