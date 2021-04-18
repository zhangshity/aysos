package com.zcy.reflect;

/**
 * @ Author: chunyang.zhang
 * @ Description:  反射验证 reflection test
 * @ Date: Created in 13:58 2018-12-29
 * @ Modified: By:
 */

public class Person {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
