package com.zcy.exception.ThrowExceptionQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
public class Main {
    //service的private方法有异常，处理后抛出，service层不处理，还会被上层的controller捕获到吗
    public static void main(String[] args) {

        Controller controller = new Controller();

        String s = controller.controllerMethod();
        System.out.println(s);


        //结果：
        // sout: controller method
        // sout : service method
        // sout : service private method
        //==============================
        //final controller catch block
        //|| : > / by zero
        //==============================
        //null


        /**
         * service 写不写 try catch  -controller都能捕获到
         *  Exception 只要throw了没人处理就一直往外抛，直到最上层,
         */

    }


}
