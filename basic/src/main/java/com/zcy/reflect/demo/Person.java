package com.zcy.reflect.demo;

public class Person {

    private String name;
    private int age;

    private String privateMethodInPerson(){
        return "private私有方法";
    }

    private String privateMethodInPersonWithArgs(String args) {
        return "参数 >>> " + args;
    }



}
