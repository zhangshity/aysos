package com.zcy.spring.aop.demo1_xml;

public class MyAspect {

    public void pointCut() {
    }

    public void before() {
        System.out.println("MyAspect . before()");
    }

    public void after() {
        System.out.println("MyAspect . after()");
    }

    public void around() {
        System.out.println("MyAspect . around()");
    }

    public void afterReturn() {
        System.out.println("MyAspect . afterReturn()");
    }

    public void afterThrowing() {
        System.out.println("MyAspect . afterThrowing()");
    }
}
