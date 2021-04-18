package com.zcy.spring.aop.demo1_xml;

public class BusinessClass {

    public void biz() {
        System.out.println("BusinessClass.biz()");
    }

    public void init(String name, int times) {
        System.out.println("businessClass.init() " + name + " " + times);
    }
}
