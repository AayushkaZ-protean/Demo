package com.protean.openfinance.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@Slf4j
public class AppConfig {

    @Value("${openfinance.thread.common}")
    private int commonThreadCount;

    @Bean("commonExecutor")
    Executor commonTaskExecutor() {
        log.warn("CommonExecutor thread count is {}", this.commonThreadCount);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(this.commonThreadCount);
        executor.setAllowCoreThreadTimeOut(true);
        executor.setMaxPoolSize(Integer.MAX_VALUE);
        executor.setQueueCapacity(Integer.MAX_VALUE);
        executor.setThreadNamePrefix("task-common-");
        executor.initialize();
        return executor;
    }

}
