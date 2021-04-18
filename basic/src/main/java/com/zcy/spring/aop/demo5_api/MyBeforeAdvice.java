package com.zcy.spring.aop.demo5_api;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("DIY Before Advice. " + method.getName() + " " + target.getClass().getName());
    }
}
