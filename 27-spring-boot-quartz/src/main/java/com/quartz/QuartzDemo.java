package com.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.UsersService;
/**
 * Job类
 *
 *
 */
public class QuartzDemo implements Job {

	@Autowired
	private UsersService usersService;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("execute--"+new Date());
		usersService.addUsers();
	}

}
