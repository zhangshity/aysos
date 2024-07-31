package com.gateway.demo.mybatis_demo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.mybatis.spring.batch.builder.MyBatisPagingItemReaderBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public MyBatisPagingItemReader<Person> reader(SqlSessionFactory sqlSessionFactory) {
        return new MyBatisPagingItemReaderBuilder<Person>()
                .sqlSessionFactory(sqlSessionFactory)
                .queryId("com.example.mapper.PersonMapper.findAll")
                .pageSize(10)
                .build();
    }

    @Bean
    public ItemProcessor<Person, Person> processor() {
        return item -> {
            String firstName = item.getFirstName().toUpperCase();
            String lastName = item.getLastName().toUpperCase();
            item.setFirstName(firstName);
            item.setLastName(lastName);
            return item;
        };
    }

    @Bean
    public MyBatisBatchItemWriter<Person> writer(SqlSessionFactory sqlSessionFactory) {
        return new MyBatisBatchItemWriterBuilder<Person>()
                .sqlSessionFactory(sqlSessionFactory)
                .statementId("com.example.mapper.PersonMapper.updatePerson")
                .build();
    }

    @Bean
    public Job importUserJob(JobBuilderFactory jobs, Step s1) {
        return jobs.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory,
                      MyBatisPagingItemReader<Person> reader,
                      ItemProcessor<Person, Person> processor,
                      MyBatisBatchItemWriter<Person> writer) {
        return stepBuilderFactory.get("step1")
                .<Person, Person>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobExecutionListenerSupport() {
        };
    }
}
