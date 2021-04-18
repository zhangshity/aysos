package com.zcy.spring.aop.demo5_api;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class MyThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception e) throws Throwable {
        System.out.println("MyThrowsAdvice . afterThrowing1(Exception e)");
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception e) throws Throwable {
        System.out.println("MyThrowsAdvice . afterThrowing2(Exception e) " + method.getName() + " " + target.getClass().getName());
    }
}
