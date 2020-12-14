package com.zcy.spring.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.zcy.spring.transaction")
@MapperScan("com.zcy.spring.transaction")
public class Test {



    public static void main(String[] args) {
        System.out.println("------------------- 开始Main方法 -----------------------");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        ServiceA serviceA = (ServiceA) context.getBean("serviceA");
        serviceA.updateMain();
    }
}
