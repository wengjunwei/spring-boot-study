package com.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * ����������
 * @author Administrator
 *
 */
public class QuartzDemo implements Job {
	/**
	 * ���񱻴���ʱ��ִ�еķ���
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("����quart:"+new Date());
	}

}
