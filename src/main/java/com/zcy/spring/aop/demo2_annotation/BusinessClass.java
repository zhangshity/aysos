package com.zcy.spring.aop.demo2_annotation;

import org.springframework.stereotype.Component;

@Component("businessClass2")
public class BusinessClass {

    public void biz() {
        System.out.println("BusinessClass2.biz()");
//        throw new RuntimeException();
    }
}
