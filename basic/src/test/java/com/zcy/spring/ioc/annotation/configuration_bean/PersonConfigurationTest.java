package com.zcy.spring.ioc.annotation.configuration_bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonConfigurationTest {

    @Test
    public void getPerson() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonConfiguration personConfiguration = (PersonConfiguration) applicationContext.getBean("personConfiguration");
        Person person = (Person) applicationContext.getBean("getPerson");
        System.out.println(personConfiguration);
        System.out.println(person);
    }
}