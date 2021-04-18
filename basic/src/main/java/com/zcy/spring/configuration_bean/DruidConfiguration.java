package com.zcy.spring.configuration_bean;

import com.zcy.collection.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfiguration {

    @Bean("stu")
    public Student getStudent() {
        System.out.println("  @Bean(\"stu\")  getStudent() ...");
        return new Student("zhangsan",18,"male");
    }

    @Bean("stu2")
    @Conditional({})
    public Student getStudent2() {
        System.out.println("  @Bean(\"stu\")  getStudent2() ...");
        return new Student("wanger",20,"male");
    }
    
    
    @Bean("init")
    public Student init(@Qualifier("stu") Student student) {
//        Student student = this.getStudent();
        student.setName("fuck");
        System.out.println("     @PostConstruct ... ");
        return student;
    }


}
