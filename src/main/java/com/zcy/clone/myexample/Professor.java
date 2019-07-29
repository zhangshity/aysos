package com.zcy.clone.myexample;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《教授类》实现Cloneable为深克隆，不实现为浅克隆
 * @ Date: Created in 09:47 2018/12/13
 * @ Modified: By:
 * <p>
 * 参考对应Github文档:
 * https://github.com/zhangshity/technote/blob/master/Java/clone()%E6%96%B9%E6%B3%95.md
 */

//public class Professor implements Cloneable {
public class Professor {

    private String name;
    private int age;

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

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


//    @Override
//    public Object clone() {
//        Object reference = null;
//        try {
//            reference = super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return reference;
//    }
}
