## 项目简介
 spring线程调度框架。可以多个线程共同工作，完成一个共同的任务。比较简单，直接上代码。

## 项目依赖
``` bash
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      <springframework.version>4.2.0.RELEASE</springframework.version>
  </properties>
  <dependencies>
         <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${springframework.version}</version>
        </dependency>
         <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${springframework.version}</version>
        </dependency>
  </dependencies>
```

## 线程池
固定周期单位是毫秒
``` bash
@Component
public class TaskExecutorDemo {

    private class MessagePrinterTask implements Runnable {

        private String message;

        public MessagePrinterTask(String message) {
            this.message = message;
        }

        public void run() {
            System.out.println(Thread.currentThread() +  message);
        }

    }

    @Autowired
    private TaskExecutor taskExecutor;

    public void printMessages() {
        for(int i = 0; i < 5; i++) {
            taskExecutor.execute(new MessagePrinterTask("Message" + i));
        }
    }

}
```


## 项目配置
通过注解来配置项目，比xml清爽多了。
``` bash
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
```

## 测试代码
``` bash
public class AppMain {
	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	}
}
```

本项目没有xml配置文件，全部以注解的方式，进行配置注入。

#### github: [https://github.com/njkfei/spring-task.git](https://github.com/njkfei/spring-task.git)
#### 项目参考：[www.websystique.com](http://www.websystique.com)
#### 个人blog: [wiki.niejinkun.com](http://wiki.niejinkun.com)
