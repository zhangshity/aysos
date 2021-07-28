package com.zcy.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean("hhh")
    public String hhh() {

        System.out.println("  测试 xml TestConfig（）   ");
        return "123";
    }
}
