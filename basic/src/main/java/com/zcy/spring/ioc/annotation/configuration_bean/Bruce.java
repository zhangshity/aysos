package com.zcy.spring.ioc.annotation.configuration_bean;

import org.springframework.stereotype.Component;

@Component("configBruce")
public class Bruce implements Person {

    private String name;
    private int age;

    {
        name = "Bruce";
        age = 8;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Bruce{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
