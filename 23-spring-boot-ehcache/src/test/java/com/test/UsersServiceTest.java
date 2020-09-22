package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.App;
import com.pojo.Users;
import com.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UsersServiceTest {
	
	@Autowired
	private UsersService usersService;
	
	@Test
	public void testFindById(){
		//第一次查询
		System.out.println(this.usersService.findUsersById(1));
		//第二次查询
		System.out.println(this.usersService.findUsersById(1));
	}
	
	@Test
	public void testFindUSersByPage(){
		Pageable pageable=new PageRequest(0, 2);
		//第一次
		System.out.println(this.usersService.findUsersByPage(pageable).getTotalElements());
		//第二次
		System.out.println(this.usersService.findUsersByPage(pageable).getTotalElements());
		pageable=new PageRequest(1, 2);
		System.out.println(this.usersService.findUsersByPage(pageable).getTotalElements());
	}
	
	/**
	 * @CacheEvict 测试
	 */
	@Test
	public void tsetFindAll(){
		//第一次
		System.out.println(this.usersService.findUsersAll().size());
		
		Users users=new Users();
		users.setAddress("广州");
		users.setAge("34");
		users.setName("小白");
		this.usersService.saveUsers(users);
		
		//第二次
		System.out.println(this.usersService.findUsersAll().size());
	}
	
}
