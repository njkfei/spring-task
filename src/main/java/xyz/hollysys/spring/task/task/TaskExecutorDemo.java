package xyz.hollysys.spring.task.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

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