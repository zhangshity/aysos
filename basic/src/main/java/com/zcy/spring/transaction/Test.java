package com.zcy.spring.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.com.zcy.spring.transaction")
@MapperScan("com.zcy.spring.transaction")
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    // 测试表语句 (附加快速清理表数据语句: truncate table student)
    // 建表语句:
    /*
        CREATE TABLE student (
            id int(11) NOT NULL AUTO_INCREMENT,
            name varchar(255) DEFAULT NULL,
            age int(11) DEFAULT NULL,
            create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
            version int(11) NOT NULL DEFAULT 0,
            PRIMARY KEY (id)
        )
    */


    public static void main(String[] args) {
        System.out.println("------------------- 开始Main方法 -----------------------");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        ServiceA serviceA = (ServiceA) context.getBean("serviceA");
        try {
            //serviceA.testListResultOfEmptyData(); //补充测试 查询表返回list是空对象还是 null
            serviceA.updateMain();
        } catch (Exception e) {
            logger.error("Test Main 主方法捕获到异常", e);
        }
    }
}
