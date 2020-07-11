package com.demo.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Springboot没有指定TaskScheduler则会创建一个单线程的默认调度器
 * 项目同时只能有一个定时任务在执行
 */
@Configuration
public class ScheduledConfig {

    //指定taskScheduler之后可以多线程执行
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(5);
        return taskScheduler;
    }

}
