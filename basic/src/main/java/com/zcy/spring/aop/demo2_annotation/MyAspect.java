package com.zcy.spring.aop.demo2_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component("myAspect2")
public class MyAspect {

    @Pointcut("execution(* com.zcy.spring.aop.demo2_annotation.BusinessClass.biz(..))")
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
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around1");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("around2");
//        System.out.println("MyAspect2 . around() " + obj);
        return obj;
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("MyAspect2 . afterReturning()");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("MyAspect2 . afterThrowing()");
    }


    //============================================================================
    @Pointcut(value = "execution(* com.zcy.spring.aop.demo2_annotation.BusinessClass.init(String,int))")
    public void pointCut2() {
    }

    @Around(value = "pointCut2() && args(name,times)")
    public Object around2(ProceedingJoinPoint pjp, String name, int times) throws Throwable {
        System.out.println("Aspect init around" + name + " " + times);
        Object o = null;
        try {
            System.out.println("Aspect init around before1 " + name + " " + times);
            o = pjp.proceed();
            System.out.println("Aspect init around after1" + name + " " + times);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {

        }
        return o;
    }


}
