package com.gateway.demo;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.Objects;


@Configuration
public class ThreadPoolConfig {

    @Value("${repayment.thread-pool-size:#{null}}")
    private Integer threadPoolSize;

    @Bean("commonTaskExecutor")
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Objects.nonNull(threadPoolSize) ? threadPoolSize : Runtime.getRuntime().availableProcessors());
        executor.setMaxPoolSize(Objects.nonNull(threadPoolSize) ? threadPoolSize : Runtime.getRuntime().availableProcessors());
        executor.setKeepAliveSeconds(0);
        executor.setQueueCapacity(4096);
        executor.setThreadNamePrefix("task-t-");
        executor.setTaskDecorator(new MdcTaskDecorator());
        executor.initialize();
        return executor;
    }


    static class MdcTaskDecorator implements TaskDecorator {
        @Override
        public Runnable decorate(Runnable runnable) {
            Map<String, String> contextMap = MDC.getCopyOfContextMap();
            return () -> {
                try {
                    if (contextMap != null) {
                        MDC.setContextMap(contextMap);
                    }
                    runnable.run();
                } finally {
                    MDC.clear();
                }
            };
        }
    }

}
