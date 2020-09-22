package com.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 通过实现HandlerExceptionResolver接口做全局异常处理
 *
 *
 */
@Configuration
public class GlobalException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		ModelAndView mv =new ModelAndView();
		
		//判断不同异常类型，做不同视图跳转
		if(arg3 instanceof ArithmeticException){
			mv.setViewName("error1");
		}
		
		if(arg3 instanceof NullPointerException){
			mv.setViewName("error2");
		}
		mv.addObject("error", arg3.toString());
		return mv;
	}
	
	
}
