package com.zcy.spring.ioc._circular_dependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.zcy.spring.ioc._circular_dependency")
@Configuration
public class BeanConfig {

    @Bean(name = "say")
    public String say() {
        return "print\"这是一个字符串@Bean\"";
    }
}
