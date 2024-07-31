package com.gateway.demo.basic_demo;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableBatchProcessing
public class TestConfig {

    @Bean
    public TestReader reader() {
        return new TestReader();
    }

    @Bean
    public TestProcessor processor() {
        return new TestProcessor();
    }

    @Bean
    public TestWriter writer() {
        return new TestWriter();
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
                .<Person, Person>chunk(10)
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
