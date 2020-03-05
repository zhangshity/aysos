package com.zcy.spring.ioc.annotation.generic2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Execute {

    @Autowired
    @Qualifier("audi2")
    private Audi audi;

    @Autowired
    @Qualifier("bmw2")
    private Bmw bmw;

    @Bean
    public Audi getAudi() {
        return new Audi();
    }

    @Bean
    public Bmw getBmw() {
        return new Bmw();
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Execute execute = (Execute) applicationContext.getBean("execute");
        System.out.println("Autowired Audi > " + execute.audi);
        System.out.println("Autowired Bmw > " + execute.bmw);

        Audi audi = (Audi) applicationContext.getBean("getAudi");
        Bmw bmw = (Bmw) applicationContext.getBean("getBmw");
        System.out.println("@Bean get Audi > " + audi);
        System.out.println("@Bean get Bmw > " + bmw);


        System.out.println(execute.audi == audi);
        System.out.println(execute.bmw == bmw);
    }

}
