package com.zcy.spring.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.zcy.spring.transaction")
@MapperScan("com.zcy.spring.transaction")
public class Test {

    // 测试表语句 (附加快速清理表数据语句: truncate table student)
    // 建表语句:
    /*
        CREATE TABLE student (
            id int(11) NOT NULL AUTO_INCREMENT,
            name varchar(255) DEFAULT NULL,
            age int(11) DEFAULT NULL,
            PRIMARY KEY (id)
        )
    */


    public static void main(String[] args) {
        System.out.println("------------------- 开始Main方法 -----------------------");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        ServiceA serviceA = (ServiceA) context.getBean("serviceA");
        serviceA.updateMain();
    }
}
