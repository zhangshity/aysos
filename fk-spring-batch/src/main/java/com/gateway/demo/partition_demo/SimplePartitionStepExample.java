//package com.gateway.demo.partition_demo;
//
//import com.gateway.demo.ThreadPoolConfig;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.MDC;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepExecution;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.partition.PartitionHandler;
//import org.springframework.batch.core.partition.support.Partitioner;
//import org.springframework.batch.core.partition.support.SimplePartitioner;
//import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
//import org.springframework.batch.core.scope.context.StepContext;
//import org.springframework.batch.core.scope.context.StepSynchronizationManager;
//import org.springframework.batch.core.step.builder.PartitionStepBuilder;
//import org.springframework.batch.item.ExecutionContext;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.support.ListItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.task.SimpleAsyncTaskExecutor;
//import org.springframework.core.task.TaskDecorator;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//@Slf4j
//@SpringBootApplication
//@EnableBatchProcessing
//public class SimplePartitionStepExample {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    public static void main(String[] args) {
//        SpringApplication.run(SimplePartitionStepExample.class, args);
//    }
//
//    @Bean
//    public Job partitionedJob(JobLauncher jobLauncher) {
//        return jobBuilderFactory.get("partitionedJob")
//                .start(partitionedStep())
//                .build();
//    }
//
//    @Bean
//    public Step partitionedStep() {
//        return stepBuilderFactory.get("partitionedStep")
//                .partitioner("slaveStep", partitioner())
//                .step(slaveStep())
//                .gridSize(4) // 假设我们有4个线程
//                .taskExecutor(taskExecutor())
//                .build();
//    }
//
//    @Bean
//    public Step slaveStep() {
//        return stepBuilderFactory.get("slaveStep")
//                .<String, String>chunk(2)
//                .reader(itemReader())
//                .processor(itemProcessor())
//                .writer(itemWriter())
//                .build();
//    }
//
//    @Bean
//    public Partitioner partitioner() {
//        return gridSize -> {
//            Map<String, ExecutionContext> partitionMap = new HashMap<>();
//
//            log.info("获取锁: {}", gridSize);
//            List<String> dataList = generateData(); // 假设这是待处理的数据列表
//
//            int partitionSize = dataList.size() / gridSize;
//
//            for (int i = 0; i < gridSize; i++) {
//                ExecutionContext context = new ExecutionContext();
//                int start = i * partitionSize;
//                int end = (i + 1) * partitionSize;
//
//                if (i == gridSize - 1) {
//                    end = dataList.size(); // 最后一个分区包含剩余的所有数据
//                }
//
//                context.putInt("startIndex", start);
//                context.putInt("endIndex", end);
//                context.put("dataList", dataList);
//
//                partitionMap.put("partition" + i, context);
//            }
//
//            return partitionMap;
//        };
//    }
//
//    @Bean
//    @SuppressWarnings("unchecked")
//    public ItemReader<String> itemReader(
////            ExecutionContext context
//    ) {
//        StepContext stepContext = StepSynchronizationManager.getContext();
//        int startIndex = stepContext.getStepExecution().getExecutionContext().getInt("startIndex");
//        int endIndex = stepContext.getStepExecution().getExecutionContext().getInt("endIndex");
//        List<String> dataList = (List<String>) stepContext.getStepExecution().getExecutionContext().get("dataList");
//
//
//        log.info("读----");
//
//        return new ListItemReader<>(dataList.subList(startIndex, endIndex));
//    }
//
//    @Bean
//    public ItemProcessor<String, String> itemProcessor() {
//        return item -> {
////            log.info("处理----{}", item);
//
//            System.out.println("Processing item: " + item);
//            return item.toUpperCase(); // 简单处理，将字符串转为大写
//        };
//    }
//
//    @Bean
//    public ItemWriter<String> itemWriter() {
//        return items -> items.forEach(item -> System.out.println("Writing item: " + item));
//    }
//
//
//    private List<String> generateData() {
//        List<String> data = new ArrayList<>();
//        for (int i = 1; i <= 20; i++) {
//            data.add("item" + i);
//        }
//        return data;
//    }
//
//
//
//    @Value("${repayment.thread-pool-size:#{null}}")
//    private Integer threadPoolSize;
//
//    @Bean("commonTaskExecutor")
//    public TaskExecutor taskExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(Objects.nonNull(threadPoolSize) ? threadPoolSize : Runtime.getRuntime().availableProcessors());
//        executor.setMaxPoolSize(Objects.nonNull(threadPoolSize) ? threadPoolSize : Runtime.getRuntime().availableProcessors());
//        executor.setKeepAliveSeconds(0);
//        executor.setQueueCapacity(4096);
//        executor.setThreadNamePrefix("task-t-");
//        executor.setTaskDecorator(new MdcTaskDecorator());
//        executor.initialize();
//        return executor;
//    }
//
//
//    static class MdcTaskDecorator implements TaskDecorator {
//        @Override
//        public Runnable decorate(Runnable runnable) {
//            Map<String, String> contextMap = MDC.getCopyOfContextMap();
//            return () -> {
//                try {
//                    if (contextMap != null) {
//                        MDC.setContextMap(contextMap);
//                    }
//                    runnable.run();
//                } finally {
//                    MDC.clear();
//                }
//            };
//        }
//    }
//}
