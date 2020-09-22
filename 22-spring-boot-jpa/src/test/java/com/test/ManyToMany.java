package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.App;
import com.dao.RoleRepository;
import com.pojo.Menus;
import com.pojo.Roles;
/**
 * 多对多的关联关系的测试
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class ManyToMany {
	
	@Autowired
	private RoleRepository RoleRepository;
	
	@Test
	public void testSave(){
		//创建角色对象
		Roles roles=new Roles();
		roles.setRolename("项目经理");
		//创建菜单对象
		Menus menus=new Menus();
		menus.setMenusname("xxx管理系统");
		menus.setFatherid(0);
		
		Menus menus2=new Menus();
		menus2.setMenusname("项目管理");
		menus2.setFatherid(1);
		
		//关联
		roles.getMenus().add(menus);
		roles.getMenus().add(menus2);
		menus.getRoles().add(roles);
		menus2.getRoles().add(roles);
		
		//保存
		this.RoleRepository.save(roles);
	}
}
