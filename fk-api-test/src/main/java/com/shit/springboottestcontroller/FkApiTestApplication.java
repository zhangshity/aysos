package com.shit.springboottestcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FkApiTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(FkApiTestApplication.class, args);
    }
}
