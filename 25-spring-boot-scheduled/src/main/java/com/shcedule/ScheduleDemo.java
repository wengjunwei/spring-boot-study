package com.shcedule;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled定时任务
 *
 *
 */
@Component
public class ScheduleDemo {
	/**
	 * 定时任务方法
	 * @Scheduled:设置定时任务
	 * cron属性：cron表达式。定时任务触发是时间的一个字符串表达形式
	 */
	@Scheduled(cron="0/2 * * * * ?")
	public void schedule(){
		System.out.println("这是一个schedule:"+new Date());
	}
}
