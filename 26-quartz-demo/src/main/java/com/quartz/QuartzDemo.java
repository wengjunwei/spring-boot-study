package com.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * 定义任务类
 * @author Administrator
 *
 */
public class QuartzDemo implements Job {
	/**
	 * 任务被触发时所执行的方法
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("这是quart:"+new Date());
	}

}
