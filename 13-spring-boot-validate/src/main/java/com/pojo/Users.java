package com.pojo;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Users {
	@NotEmpty  //判断字符串是否null或者是空串
	private String name;
	@NotBlank(message="密码不能为空")  //非空校验   。。 。 判断字符串是否为null或者是空串(去掉首尾空格)
	@Length(min=2,max=6,message="最小长度为2，最大长度为6") //判断字符串的长度
	private String password;
	@Min(value=15)     //判断最小值
	private String age;
	
	@Email
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", password=" + password + ", age=" + age + "]";
	}
	public Users(String name, String password, String age) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
	}
	public Users() {
		super();
	}
	
	
}
