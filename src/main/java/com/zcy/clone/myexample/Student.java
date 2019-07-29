package com.zcy.clone.myexample;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《学生类》 实现 Cloneable接口
 * @ Date: Created in 09:47 2018/12/13
 * @ Modified: By:
 * <p>
 * 参考对应Github文档:
 * https://github.com/zhangshity/technote/blob/master/Java/clone()%E6%96%B9%E6%B3%95.md
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

    //克隆需重写 Cloneable接口的clone()方法
    @Override
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
