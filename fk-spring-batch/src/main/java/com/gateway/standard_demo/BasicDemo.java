package com.gateway.standard_demo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
//@Configuration
public class BasicDemo {
    /**
     * 数据量
     */
    private static final int DATA_SIZE = 10;
    /**
     * 处理块大小
     */
    public static final int CHUNK_SIZE = 5;

    @Resource
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job basicJob(JobBuilderFactory jobs) {
        return jobs.get("basicJob")
                .incrementer(new RunIdIncrementer())
                .start(basicStep())
                .build();
    }


    @Bean
    public Step basicStep() {
        return stepBuilderFactory.get("basicStep")
                .<Person, Person>chunk(CHUNK_SIZE)
                .reader(basicReader())
                .processor(basicProcessor())
                .writer(basicWriter())
                .build();
    }


    @Bean
    public ItemReader<Person> basicReader() {
        return new ItemReader<Person>() {
            private Iterator<Person> cache = null;

            @Override
            public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
                // 初始化缓存
                if (cache == null) {
                    cache = fetchData(); //一次性读取
                }
                // 缓存为空终止read()
                if (!cache.hasNext()) {
                    cache = null; // 清空返回
                    return null; // 终止read
                }
                // 每次read()被调用,返回缓存中数据
                return cache.next();
            }

            private Iterator<Person> fetchData() {
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
                return dataList.iterator();
            }
        };
    }

    @Bean
    public ItemProcessor<Person, Person> basicProcessor() {
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
    public ItemWriter<Person> basicWriter() {
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
