package com.zcy.spring.aop.demo3_introduction_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Fit fit = (Fit) applicationContext.getBean("businessClass3");
        fit.filter();

        //获取的业务类bean - businessClass3，却返回了Fit接口实现类
        /**
         *  <aop:declare-parents
         *          types-matching="com.com.zcy.spring.aop.demo3_introduction.BusinessClass"
         *          implement-interface="com.com.zcy.spring.aop.demo3_introduction.Fit"
         *          default-impl="com.com.zcy.spring.aop.demo3_introduction.FitImpl"
         *  />
         */
    }
}
