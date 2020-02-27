package com.zcy.spring.jsr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JsrService jsrService = (JsrService) applicationContext.getBean("jsrService");
        jsrService.save();
    }
}
