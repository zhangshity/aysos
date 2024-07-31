package com.gateway.demo.trigger_demo.mybatis_official;

import com.gateway.demo.mybatis_demo.Person;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.mybatis.spring.batch.builder.MyBatisPagingItemReaderBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
public class MybatisOfficialSpringBatchConfig {

    private static final Logger log = LoggerFactory.getLogger(MybatisOfficialSpringBatchConfig.class);


    @Bean("mybatis-reader")
    public MyBatisPagingItemReader<Person> reader(SqlSessionFactory sqlSessionFactory) {
//        log.info("mybatis reader");
        MyBatisPagingItemReader<Person> build = new MyBatisPagingItemReaderBuilder<Person>()
                .sqlSessionFactory(sqlSessionFactory)
                .queryId("com.gateway.demo.trigger_demo.mybatis.PersonMapper.selectAll")
                .pageSize(10)
                .build();

//        log.info("mybatis reader {}", build);

        return build;
    }

    @Bean("mybatis-processor")
    public ItemProcessor<Person, Person> processor() {
        return item -> {
            log.info("--> mybatis data process start {}", item);

            String firstName = item.getFirstName().toUpperCase();
            String lastName = item.getLastName().toUpperCase();
            item.setFirstName(firstName);
            item.setLastName(lastName);

            log.info("--> mybatis data process end {}", item);
            return item;
        };
    }

    @Bean("mybatis-writer")
    public MyBatisBatchItemWriter<Person> writer(SqlSessionFactory sqlSessionFactory) {
//        log.info("mybatis writer {}", sqlSessionFactory);
        return new MyBatisBatchItemWriterBuilder<Person>()
                .sqlSessionFactory(sqlSessionFactory)
                .statementId("com.gateway.demo.trigger_demo.mybatis.PersonMapper.insertPerson")
                .build();
    }


    @Autowired
    @Qualifier("mybatis-step")
    private Step s1;




    @Bean("mybatis-job")
    public Job job(JobBuilderFactory jobs) {
        return jobs.get("mybatis-job-1")
                .incrementer(new RunIdIncrementer())
                .listener(new JobExecutionListenerSupport())
                .flow(s1)
                .end()
                .build();
    }

    @Bean("mybatis-step")
    public Step step(StepBuilderFactory stepBuilderFactory,
                      MyBatisPagingItemReader<Person> reader,
                      ItemProcessor<Person, Person> processor,
                      MyBatisBatchItemWriter<Person> writer) {
        return stepBuilderFactory.get("step")
                .<Person, Person>chunk(1)
                .reader(reader)
                .processor(processor())
                .writer(writer)
                //.transactionManager() //TODO 事务待测试
                .build();
    }

//    @Bean("mybatis-listener")
//    public JobExecutionListener listener() {
//        return new JobExecutionListenerSupport() {
//        };
//    }
}
