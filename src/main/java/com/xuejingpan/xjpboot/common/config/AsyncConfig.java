package com.xuejingpan.xjpboot.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName AsyncConfig
 * @Description 异步配置
 * @Author xuejingpan
 * @Date 2023/3/17 23:42
 * @Version 1.0
 */
@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    @Bean
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(10);
        // 最大线程数
        executor.setMaxPoolSize(20);
        // 缓冲队列
        executor.setQueueCapacity(10);
        // 空闲时间
        executor.setKeepAliveSeconds(30);
        // 前缀名称
        executor.setThreadNamePrefix("xjp-boot-");
        // 停机策略
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }
}
