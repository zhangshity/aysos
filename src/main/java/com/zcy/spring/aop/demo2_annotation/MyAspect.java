package com.zcy.spring.aop.demo2_annotation;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component("myAspect2")
public class MyAspect {

    @Pointcut("execution(* com.zcy.spring.aop.demo2_annotation.BusinessClass.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("MyAspect2 . before()");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("MyAspect2 . after()");
    }

    @Around("pointCut()")
    public void around() {
        System.out.println("MyAspect2 . around()");
    }

    @AfterReturning("pointCut()")
    public void afterReturn() {
        System.out.println("MyAspect2 . afterReturn()");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("MyAspect2 . afterThrowing()");
    }
}
