package com.zcy.spring.configuration_bean;

import com.zcy.collection.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DruidConfiguration.class);
        Student stu = (Student) applicationContext.getBean("stu");
        Student stu2 = (Student) applicationContext.getBean("stu2");
        Student init = (Student) applicationContext.getBean("init");


        System.out.println(stu + " " + stu.hashCode());
        System.out.println(stu2 + " " + stu2.hashCode());
        System.out.println(init + " " + init.hashCode());


    }
}
