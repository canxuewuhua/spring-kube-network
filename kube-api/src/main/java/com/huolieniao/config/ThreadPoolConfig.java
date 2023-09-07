package com.huolieniao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

/**
 * 自定义线程池
 * 2023-09-05 18:56:18.998  INFO 7559 --- [     MyThread-1] c.h.service.AsynchronousService          : execute async method......
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setMaxPoolSize(50);
        taskExecutor.setQueueCapacity(200);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadNamePrefix("MyThread-");
        taskExecutor.setAwaitTerminationSeconds(60);
        return taskExecutor;
    }
}
