package com.gateway.demo.list_demo;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

//@Configuration
//@EnableBatchProcessing
public class ListTestConfig {

    @Bean
    public ItemReader<Person> reader() {
        List<Person> persons = Arrays.asList(
                new Person("John", "Doe"),
                new Person("Jane", "Doe"),
                new Person("Max", "Mustermann")
        );
        System.out.println("读数据 "+ persons);
        return new ListItemReader<>(persons);
    }

    @Bean
    public ItemProcessor<Person, Person> processor() {
        return new PersonItemProcessor();
    }

    @Bean
    public ItemWriter<Person> writer() {
        return new ConsoleItemWriter();
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
                      ItemReader<Person> reader,
                      ItemProcessor<Person, Person> processor,
                      ItemWriter<Person> writer) {
        return stepBuilderFactory.get("step1")
                .<Person, Person>chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobExecutionListenerSupport() {};
    }

}
