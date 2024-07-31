package com.gateway.demo.trigger_demo.mybatis_customize;


import com.gateway.demo.trigger_demo.Person;
import com.gateway.demo.trigger_demo.PersonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;


@Slf4j
@Configuration
public class MybatisCustomizeSpringBatchConfig {
    @Resource
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    private PersonMapper mapper;


    // 读
//    @StepScope
    @Bean("reader-final")
//    public ItemReader<Person> reader(@Value("#{jobParameters['shit']}") String shit) {
    public ItemReader<Person> reader() {
        log.info("初始化Reader");

        // 【1】 完全自定义Reader
        return new ItemReader<Person>() {

            private Iterator<Person> cache;

            private JobParameters jobParameters;

            @BeforeStep
            public void beforeStep(StepExecution stepExecution) {
                jobParameters = stepExecution.getJobParameters();
                log.info("@BeforeStep 初始化 jobParameters: {}", jobParameters);
            }


            @Override
            public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
                log.info("读取数据时使用参数 {}", jobParameters.getString("shit"));

                // 初始化
                if (cache == null) {
                    reloadData();
                }

                // 循环读取
                if (!cache.hasNext()) {
                    reloadData();
                    if (!cache.hasNext()) {
                        return null;
                    }
                }

                return cache.next();
            }

            private void reloadData() {
                // 读取一批数据
                List<Person> personList = mapper.selectAllLimitEnabled(0,1000);
                log.info("mybatis查询待处理数据 {}", personList.size());
                cache = personList.iterator();
            }
        };




//        //【2】 利用封装的ItemReader
//        // 1.读取一批数据
//        List<Person> personList = mapper.selectAllLimitEnabled(0,5);
//        log.info("mybatis查询待处理数据 {}", personList.size());
//
//        // 2.返回listReader，spring-batch自行逐个读取
//        return new IteratorItemReader<Person>(personList);






//        //【3】利用封装的MyBatisCursorItemReader
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("status", 0);
//
//        return new MyBatisCursorItemReaderBuilder<Person>()
//                .sqlSessionFactory(sqlSessionFactory)
//                .queryId("com.gateway.demo.trigger_demo.PersonMapper.selectAllEnabled")
//                .parameterValues(paramMap)
//                .maxItemCount(20) //job执行一次查询最大数量
//                .build();





//        //【4】利用封装的MyBatisPagingItemReader
//         HashMap<String, Object> paramMap = new HashMap<>();
//         paramMap.put("status", 0);
//
//        return new MyBatisPagingItemReaderBuilder<Person>()
//                .sqlSessionFactory(sqlSessionFactory)
//                .queryId("com.gateway.demo.trigger_demo.PersonMapper.selectAllEnabled")
//                .parameterValues(paramMap)
//                .pageSize(20)
//                //.maxItemCount(20) //job执行一次查询最大数量
//                .build();

    }

    // 处理
    @Bean("processor-final")
    public ItemProcessor<Person, Person> processor() {
        return new ItemProcessor<Person, Person>() {
            @Override
            public Person process(Person item) throws Exception {
                log.info("处理数据 {}", item);

                // 姓 名变大写
                item.setFirstName(item.getFirstName().toUpperCase());
                item.setLastName(item.getLastName().toUpperCase());

                // 状态 时间
                item.setStatus(1);
                item.setGmtTime(LocalDateTime.now());

                return item;
            }
        };
    }

    // 写
    @Bean("writer-final")
    public ItemWriter<Person> writer() {
        log.info("初始化Writer");


        // 【1】 完全自定义Writer
        return new ItemWriter<Person>() {
            @Override
            public void write(List<? extends Person> items) throws Exception {
                log.info("-----> 批量更新数据 {}", items);
                for (int i = 0; i < items.size(); i++) {
                    Person item = items.get(i);
                    log.info("{}更新数据 {}", i + 1, item);

                    int affectRows = mapper.update(item);

                      if (affectRows != 1) {
                          throw new IllegalStateException("更新数据失败");
                      }
                }
            }
        };


//        // 【2】 利用封装的MyBatisBatchItemWriter
//        return new MyBatisBatchItemWriterBuilder<Person>()
//                .sqlSessionFactory(sqlSessionFactory)
//                .statementId("com.gateway.demo.trigger_demo.PersonMapper.update")
//                .build();
    }




    @Bean("mybatis-customize-job")
    public Job job(JobBuilderFactory jobs,
                   StepBuilderFactory stepBuilderFactory) {
        return jobs.get("mybatis-customize-job")
                .incrementer(new RunIdIncrementer())
                .listener(new JobExecutionListenerSupport()) //指定监控
                .flow(stepBuilderFactory.get("mybatis-customize-step")
                        .<Person, Person>chunk(20)
                        .reader(reader())
                        .processor(processor())
                        .writer(writer())
                        //.taskExecutor(taskExecutor) // 线程池
                        //.transactionManager() //指定默认事务
                        .build())
                //.start(s2)
                //.from(s3)
                .end()
                .build();
    }








    @Autowired
    @Qualifier("reader-final")
    private ItemReader<Person> reader;

    @Autowired
    @Qualifier("processor-final")
    private ItemProcessor<Person, Person> processor;

    @Autowired
    @Qualifier("writer-final")
    private ItemWriter<Person> writer;

    @Autowired
    @Qualifier("springTaskExecutor")
    private ThreadPoolTaskExecutor taskExecutor;




    @Bean("springTaskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(1024);
        executor.setThreadNamePrefix("spring-batch");
        executor.initialize();
        return executor;
    }

}
