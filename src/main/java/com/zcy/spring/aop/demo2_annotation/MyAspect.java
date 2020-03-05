package com.zcy.spring.aop.demo2_annotation;

import org.aspectj.lang.JoinPoint;
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
    public void around(JoinPoint joinPoint) {
        String j = joinPoint.getKind();
        System.out.println("MyAspect2 . around() " + j);
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("MyAspect2 . afterReturning()");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("MyAspect2 . afterThrowing()");
    }
}
