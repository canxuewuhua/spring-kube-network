package com.huolieniao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义线程池
 * 2023-09-05 18:56:18.998  INFO 7559 --- [     MyThread-1] c.h.service.AsynchronousService          : execute async method......
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    /**
     * 七大参数 核心线程 最大线程 队列容量 最大线程空闲时间 线程工厂 拒绝策略
     * @return
     */
    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setMaxPoolSize(50);
        taskExecutor.setQueueCapacity(1000);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadNamePrefix("MyThread-");
        taskExecutor.setThreadFactory(Executors.defaultThreadFactory());
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return taskExecutor;
    }
}
