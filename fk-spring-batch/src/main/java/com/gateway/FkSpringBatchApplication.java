package com.gateway;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableBatchProcessing
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class FkSpringBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(FkSpringBatchApplication.class, args);
    }
}
