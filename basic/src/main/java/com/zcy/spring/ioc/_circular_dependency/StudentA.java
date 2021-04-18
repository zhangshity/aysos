package com.zcy.spring.ioc._circular_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Scope(value = "prototype")
@Component
public class StudentA {

    @Autowired
    private StudentB studentB;

    public StudentA() {
    }

    //@Autowired
    public StudentA(StudentB studentB) {
        this.studentB = studentB;
    }

    //@Autowired
    public void setStudentB(StudentB studentB) {
        this.studentB = studentB;
    }

    public void say() {
        System.out.println("我是学生A -> 依赖学生B|" + studentB);
    }
}
