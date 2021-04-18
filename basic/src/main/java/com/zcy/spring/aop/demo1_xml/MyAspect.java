package com.zcy.spring.aop.demo1_xml;

import org.aspectj.lang.ProceedingJoinPoint;

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

    public void afterReturning() {
        System.out.println("MyAspect . afterReturning()");
    }

    public void afterThrowing() {
        System.out.println("MyAspect . afterThrowing()");
    }

    public Object around2xml(ProceedingJoinPoint pjp, String name, int times) throws Throwable {
        System.out.println("Aspect init around" + name + " " + times);
        Object o = null;
        try {
            System.out.println("Aspect init around before " + name + " " + times);
            o = pjp.proceed();
            System.out.println("Aspect init around after" + name + " " + times);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return o;
    }
}
