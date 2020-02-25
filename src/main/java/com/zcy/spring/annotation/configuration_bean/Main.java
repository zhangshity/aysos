package com.zcy.spring.annotation.configuration_bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonConfiguration personConfiguration = (PersonConfiguration) applicationContext.getBean("personConfiguration");
        Person person = (Person) applicationContext.getBean("getPerson");
        System.out.println(personConfiguration);
        System.out.println(person);
    }
}
