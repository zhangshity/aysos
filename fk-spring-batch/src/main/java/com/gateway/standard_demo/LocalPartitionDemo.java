package com.gateway.standard_demo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
//@Configuration
public class LocalPartitionDemo {
    /**
     * 数据量
     */
    private static final int DATA_SIZE = 10000;
    /**
     * 分区最大数据量
     */
    private static final int MAX_ITEMS_PER_PARTITION = 100;
    /**
     * 处理块大小
     */
    public static final int CHUNK_SIZE = 5;

    @Resource
    private StepBuilderFactory stepBuilderFactory;
    @Resource(name = "commonTaskExecutor")
    private TaskExecutor commonTaskExecutor;


    @Bean
    public Job localPartitionJob(JobBuilderFactory jobs) {
        return jobs.get("localPartitionJob")
                .incrementer(new RunIdIncrementer())
                .start(masterStep())
                .build();
    }


    @Bean
    public Step masterStep() {
        return stepBuilderFactory.get("masterStep")
                .partitioner(slaveStep().getName(), rangePartitioner())
                .step(slaveStep())
//                .gridSize(((ThreadPoolTaskExecutor) commonTaskExecutor).getCorePoolSize()) // 不指定会根据线程池自动调整
//                .gridSize(2)
                .taskExecutor(commonTaskExecutor)
                .build();
    }

    @Bean
    public Partitioner rangePartitioner() {
        return new Partitioner() {
            @Override
            public Map<String, ExecutionContext> partition(int gridSize) {
                // 读取数据
                List<Person> dataList = fetchData();

                // 分区数据
                gridSize = calcGridSize(dataList.size(), gridSize); // 动态调整gridSize
                if (dataList.isEmpty()) {
                    return new HashMap<>(); // 空分区映射，停止任务
                }
                if (dataList.size() < gridSize) {
                    gridSize = 1;
                }
                int range = dataList.size() / gridSize;
                int fromIndex = 0;
                int toIndex = range;

                Map<String, ExecutionContext> result = new HashMap<>();
                for (int i = 1; i <= gridSize; i++) {
                    ExecutionContext value = new ExecutionContext();
                    value.put("dataList", new ArrayList<>(dataList.subList(fromIndex, toIndex)));
                    result.put("partition" + i, value);
                    fromIndex = toIndex;
                    toIndex += range;
                    if (i == gridSize - 1) {
                        toIndex = dataList.size(); // 最后一个分区包含剩余的所有数据
                    }
                }
                return result;
            }

            private List<Person> fetchData() {
                List<Person> dataList = new ArrayList<>();
                // 创建
                for (int count = 1; count <= DATA_SIZE; count++) {
                    Person person = new Person();
                    person.setFirstName("John" + count);
                    person.setLastName("Doe" + count);
                    dataList.add(person);
                }
                // 返回
                log.info("[read]->读取数据({}) {}", dataList.size(), dataList);
                return dataList;
            }

            private int calcGridSize(int dataSize, int originalGridSize) {
                return Math.max(originalGridSize, dataSize / MAX_ITEMS_PER_PARTITION);
            }
        };
    }


    @Bean
    public Step slaveStep() {
        return stepBuilderFactory.get("slaveStep")
                .<Person, Person>chunk(CHUNK_SIZE)
                .reader(partReader(null))
                .processor(partProcessor())
                .writer(partWriter())
                .build();
    }


    @Bean
    @StepScope
    public ItemReader<Person> partReader(@Value("#{stepExecutionContext[dataList]}") final List<Person> dataList) {
        return new ItemReader<Person>() {
            private Iterator<Person> cache = dataList.iterator();

            @Override
            public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
                if (!cache.hasNext()) {
                    return null;
                }
                return cache.next();
            }
        };
    }

    @Bean
    public ItemProcessor<Person, Person> partProcessor() {
        return new ItemProcessor<Person, Person>() {
            @Override
            public Person process(Person item) throws Exception {
                log.info("[process]->处理数据 {}", item);
                // 姓 名变大写
                item.setFirstName(item.getFirstName().toUpperCase());
                item.setLastName(item.getLastName().toUpperCase());
                return item;
            }
        };
    }

    @Bean
    public ItemWriter<Person> partWriter() {
        return new ItemWriter<Person>() {
            @Override
            public void write(List<? extends Person> items) throws Exception {
                log.info("[write]->批量写入数据({}) {}", items.size(), items);
            }
        };
    }


    // ---------------------------------------------------
    // inner entity

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Person {
        private Long id;
        private String firstName;
        private String lastName;
        private Integer status;
        private LocalDateTime gmtTime;
    }

}
