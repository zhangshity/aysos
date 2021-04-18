package com.zcy.spring.ioc._circular_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Scope(value = "prototype")
@Component
public class StudentB {

    @Autowired
    private StudentC studentC;

    public StudentB() {
    }

    //@Autowired
    public StudentB(StudentC studentC) {
        this.studentC = studentC;
    }

    //@Autowired
    public void setStudentC(StudentC studentC) {
        this.studentC = studentC;
    }

    public void say() {
        System.out.println("我是学生B -> 依赖学生C|" + studentC);
    }
}
