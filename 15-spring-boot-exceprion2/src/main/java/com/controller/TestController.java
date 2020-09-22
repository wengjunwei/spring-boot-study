package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * SpringBoot处理异常方式二：exceprionHandeler
 *
 *
 */
import org.springframework.web.servlet.ModelAndView;
@Controller
public class TestController {
	
	@RequestMapping("/show")
	public String showMsg(){
		String str=null;
		System.out.println(str.length());
		return "index";
	}
	
	

	@RequestMapping("/show2")
	public String show2(){
		int a=10/0;
		return "index";
	}
	
	/**
	 * java.lang.ArithmeticException
	 * 该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图的指定
	 * 参数Exception e:会将产生异常对象注入到方法中
	 */
	@ExceptionHandler(value={java.lang.ArithmeticException.class})
	public ModelAndView arithmeticException(Exception e){
		ModelAndView mv=new ModelAndView();
		mv.addObject("error",e.toString());
		mv.setViewName("error1");
		return mv;
	}
	
	
	/**
	 * java.lang.NullPointerException
	 * 该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图的指定
	 * 参数Exception e:会将产生异常对象注入到方法中
	 */
	@ExceptionHandler(value={java.lang.NullPointerException.class})
	public ModelAndView nullPointerException(Exception e){
		ModelAndView mv=new ModelAndView();
		mv.addObject("error",e.toString());
		mv.setViewName("error2");
		return mv;
	}
}
