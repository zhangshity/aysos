package com.zcy.spring.ioc._circular_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope(value = "prototype")
@Component
public class StudentC {

    @Autowired
    private StudentA studentA;

    public StudentC() {
    }

    //@Autowired
    public StudentC(StudentA studentA) {
        this.studentA = studentA;
    }

    //@Autowired
    public void setStudentA(StudentA studentA) {
        this.studentA = studentA;
    }

    public void say() {
        System.out.println("我是学生C -> 依赖学生A|" + studentA);
    }
}
