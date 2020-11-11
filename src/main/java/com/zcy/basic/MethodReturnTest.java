package com.zcy.basic;

import com.zcy.reflect.clazz.Student;

public class MethodReturnTest {


    public Student getStudent(int num) {
        if (num == 1) {
            return new Student();
        }
        return null;
    }

    public static void main(String[] args) {
        MethodReturnTest test = new MethodReturnTest();
        Student student = test.getStudent(2);

        System.out.println(student);
    }

}
