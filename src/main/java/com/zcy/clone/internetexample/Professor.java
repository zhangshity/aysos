package com.zcy.clone.internetexample;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《浅克隆-对象类》<ShadowCopy-object/>
 * @ Date: Created in 14:47 2019-07-29
 * @ Modified: By:
 * <p>
 * 参考对应Github文档:
 * https://github.com/zhangshity/technote/blob/master/Java/clone()%E6%96%B9%E6%B3%95.md
 */
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
        return "Professor [name=" + name + ", age=" + age + "]";
    }

}
