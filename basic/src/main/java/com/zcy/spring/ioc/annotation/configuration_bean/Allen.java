package com.zcy.spring.ioc.annotation.configuration_bean;

import org.springframework.stereotype.Component;

@Component("configAllen")
public class Allen implements Person {

    private String name;
    private int age;

    {
        name = "Allen";
        age = 18;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Allen{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
