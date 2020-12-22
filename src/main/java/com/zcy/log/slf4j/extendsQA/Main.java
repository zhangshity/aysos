package com.zcy.log.slf4j.extendsQA;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.zcy.log.slf4j.extendsQA")
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        SonClass sonClass = (SonClass) applicationContext.getBean(SonClass.class);
        sonClass.print();
        sonClass.execute();
    }

}
