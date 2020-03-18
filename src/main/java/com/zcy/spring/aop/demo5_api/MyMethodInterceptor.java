package com.zcy.spring.aop.demo5_api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("MyMethodInterceptor1 " + invocation.getMethod().getName() + " " + invocation.getStaticPart().getClass().getName());
        Object o = invocation.proceed();
        System.out.println("MyMethodInterceptor2 " + o);
        return o;
    }
}
