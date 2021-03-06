package xyz.hollysys.spring.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
@EnableScheduling
@ComponentScan(basePackages = "xyz.hollysys.spring.task.task")
public class AppConfig {
	@Bean(name="taskExecutor")
	public TaskExecutor taskExecutor(){
		ThreadPoolTaskExecutor executor =  new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(4);
		executor.setMaxPoolSize(8);
		executor.setQueueCapacity(8);
		return executor;
	}
}