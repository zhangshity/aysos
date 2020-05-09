package com.zcy.spring.aop.demo1_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BusinessClass businessClass = (BusinessClass) applicationContext.getBean("businessClass");
        businessClass.biz();
        businessClass.init("名字", 22);
    }
}
