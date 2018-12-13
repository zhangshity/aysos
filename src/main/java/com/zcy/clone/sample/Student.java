package com.zcy.clone.sample;

/**
 * @ Author: chunyang.zhang
 * @ Description: 学生类 实现 Cloneable接口
 * @ Date: Created in 09:47 2018/12/13
 * @ Modified: By:
 */

public class Student implements Cloneable {

    private String name;

    private int age;

    private Professor professor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", professor=" + professor +
                '}';
    }


    @Override//伪代码,但可以让编译器检查缩写代码是否为父类代码所有
    public Object clone() {
        Object reference = null;
        try {
            reference = super.clone();
        } catch (CloneNotSupportedException e) { //异常直接处理了不上抛
            e.printStackTrace();
        }
        return reference;
    }


}
