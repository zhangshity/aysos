package com.zcy.spring.aop.demo5_api;

import java.lang.reflect.Method;

public class MyAfterReturningAdvice implements org.springframework.aop.AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("MyAfterReturningAdvice " + method.getName() + " " + target.getClass().getName() + " " + returnValue);
    }
}
