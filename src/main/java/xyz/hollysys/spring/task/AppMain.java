package xyz.hollysys.spring.task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import xyz.hollysys.spring.task.config.AppConfig;
import xyz.hollysys.spring.task.task.TaskExecutorDemo;

public class AppMain {
	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		TaskExecutorDemo taskExecutorDemo = (TaskExecutorDemo) context.getBean("taskExecutorDemo");
		
		taskExecutorDemo.printMessages();
	}
}