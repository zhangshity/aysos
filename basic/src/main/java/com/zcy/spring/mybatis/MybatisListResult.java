package com.zcy.spring.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)  //允许代码中获取proxy类  // 暴露当前代理对象到当前线程绑定
@ComponentScan({"com.zcy.spring.mybatis",
        "com.zcy.spring.transaction.config",
        "com.zcy.spring.transaction.dao"})
public class MybatisListResult {

    private static final Logger logger = LoggerFactory.getLogger(MybatisListResult.class);

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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MybatisListResult.class);
        StudentService service = context.getBean(StudentService.class);

        try {
            service.testListResultOfEmptyData(); //补充测试 查询表返回list是 ✔空对象 还是 ✘null
        } catch (Exception e) {
            logger.error("Test Main 主方法捕获到异常", e);
        }
    }
}
