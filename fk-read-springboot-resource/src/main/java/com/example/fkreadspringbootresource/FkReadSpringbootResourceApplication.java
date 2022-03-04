package com.example.fkreadspringbootresource;

import com.example.fkreadspringbootresource.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FkReadSpringbootResourceApplication implements ApplicationRunner {

    @Autowired
    TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(FkReadSpringbootResourceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        testService.test();
    }
}
