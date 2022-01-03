package com.argentstew.simulator.battle.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * com.argentstew.simulator.battle.web.config
 * 1/2/2022
 *
 * @author argen
 */
@Configuration
@EnableAsync
@EnableScheduling
public class SchedulerConfig {

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setThreadNamePrefix("ABS-Exeggcutor-");
        taskExecutor.setCorePoolSize(6);
        taskExecutor.setMaxPoolSize(12);
        taskExecutor.setQueueCapacity(24);
        taskExecutor.afterPropertiesSet();
        return taskExecutor;
    }
}
