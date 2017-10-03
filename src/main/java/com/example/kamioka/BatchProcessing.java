package com.example.kamioka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BatchProcessing {

    @Configuration
    public static class S implements SchedulingConfigurer {
        @Override
        public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
            ThreadPoolTaskScheduler s = new ThreadPoolTaskScheduler();
            s.setPoolSize(5);
            s.initialize();
            taskRegistrar.setTaskScheduler(s);
        }
    }

    @Autowired
    private Counter counter;

    @Scheduled(initialDelay = 1000, fixedDelay = 10000)
    public void fixedDelay() throws InterruptedException {
        System.out.println(Thread.currentThread() + ": BatchProcessing.fixedDelay(): in");
        Thread.sleep(30000L);
        System.out.println(Thread.currentThread() + ": BatchProcessing.fixedDelay(): out");
    }

    @Scheduled(cron = "0,15,30,45 * * * * *")
    public void cron() {
        System.out.println(Thread.currentThread() + ": BatchProcessing.cron(): " + new Date());
        System.out.println(counter.getCount());
    }
}
