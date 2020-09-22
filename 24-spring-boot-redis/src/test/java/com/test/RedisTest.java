package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.App;
import com.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class RedisTest {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 添加一个字符串
	 */
	@Test
	public void testSet(){
		this.redisTemplate.opsForValue().set("key", "hello world");
	}
	
	/**
	 * 获取一个字符串
	 */
	@Test
	public void testGet(){
		String value = (String)this.redisTemplate.opsForValue().get("key");
		System.out.println(value);
	}
	
	
	/**
	 * 添加Users对象
	 */
	@Test
	public void testSetUsers(){
		Users users=new Users();
		users.setAge(18);
		users.setId(1);
		users.setName("张三");
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		this.redisTemplate.opsForValue().set("users", users);
	}
	
	/**
	 * 获取Users对象
	 */
	@Test
	public void testGetUsers(){
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		Users users=(Users)this.redisTemplate.opsForValue().get("users");
		System.out.println(users);
	}
	
	/**
	 * 添加Json对象
	 */
	@Test
	public void testSetUsersJson(){
		Users users=new Users();
		users.setAge(18);
		users.setId(1);
		users.setName("张三三");
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		this.redisTemplate.opsForValue().set("users_json", users);
	}
	
	/**
	 * 获取Json对象
	 */
	@Test
	public void testGetUsersJson(){
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		Users users=(Users)this.redisTemplate.opsForValue().get("users_json");
		System.out.println(users);
	}
	
}
