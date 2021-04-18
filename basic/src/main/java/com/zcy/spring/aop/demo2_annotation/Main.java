package com.zcy.spring.aop.demo2_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BusinessClass businessClass = (BusinessClass) applicationContext.getBean("businessClass2");
        businessClass.biz();
        businessClass.init("名字",3000);
    }
}
