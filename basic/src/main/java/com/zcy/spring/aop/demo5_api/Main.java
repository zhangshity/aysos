package com.zcy.spring.aop.demo5_api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BizLogic bizLogic = (BizLogic) applicationContext.getBean("bizLogicImpl");
        bizLogic.save();
    }
}
