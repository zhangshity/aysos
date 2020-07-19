package com.zcy.spring.ioc._circular_dependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //注解配置获取bean（AnnotationConfigApplicationContext）
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        System.out.println("===========循环依赖测试Main函数==============");

        String s = (String) context.getBean("say");
        System.out.println(s);

        StudentA a = (StudentA) context.getBean("studentA");
        StudentB b = (StudentB) context.getBean("studentB");
        StudentC c = (StudentC) context.getBean("studentC");
        System.out.println(a + "\n" + b + "\n" + c);
        System.out.println("=========================================");

        a.say();
        b.say();
        c.say();
    }

}
