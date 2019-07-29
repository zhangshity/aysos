package com.zcy.clone.internetexample;

import com.zcy.clone.sample.Professor;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《深克隆-主类(包含对象类)》<ShadowCopy-MainClass/>
 * @ Date: Created in 14:47 2019-07-29
 * @ Modified: By:
 * <p>
 * 参考对应Github文档:
 * https://github.com/zhangshity/technote/blob/master/Java/clone()%E6%96%B9%E6%B3%95.md
 */
public class Student implements Cloneable {

    private String name;
    private int age;
    private Professor professor;//对象类属性


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
        return "Student [name=" + name + ", age=" + age + ", professor="
                + professor + "]";
    }

    //克隆的关键方法
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
