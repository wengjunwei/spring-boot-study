package com.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMain {

	public static void main(String[] args) throws SchedulerException {
		// 1.����Job������Ҫ��ʲô�£�
		JobDetail job=JobBuilder.newJob(QuartzDemo.class).build();
		
		/**
		 * �򵥵�trigger����ʱ�䣺ͨ��Quartz�ṩһ����������ɼ򵥵��ظ����� cron
		 * Trigger������Cron�ı��ʽ������������ʱ��
		 */
		// 2.����Trigger������ʲôʱ������
//		Trigger trigger=TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever()).build();
		
		Trigger trigger=TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();
		
		// 3.����Scheduler������ʲôʱ����ʲô�£�
		Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
		scheduler.scheduleJob(job, trigger);
		
		//����
		scheduler.start();
	}

}
