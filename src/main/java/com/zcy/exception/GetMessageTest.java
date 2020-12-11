package com.zcy.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetMessageTest {

    public static void main(String[] args) throws InterruptedException {

        Logger logger = LoggerFactory.getLogger(GetMessageTest.class);

        try {
            //int i = 1 / 0;
            throw new RuntimeException("测试代码！异常！");

        } catch (Exception e) {
            System.out.println("------------- e.printStackTrace() --------------");
            e.printStackTrace();

            Thread.sleep(500);

            System.out.println("------------- e.getMessage() --------------");
            System.out.println(e.getMessage()); //除以零

            System.out.println("------------- e.toString() --------------");
            System.out.println(e.toString());  //java.lang.ArithmeticException: 除以零

            System.out.println("------------- e.getCause() --------------");
            System.out.println(e.getCause());  //Exception in thread "main" java.lang.NullPointerException
                                                          //    at com.zcy.exception.GetMessageTest.main(GetMessageTest.java:21)

//            System.out.println("------------- e.getLocalizedMessage() --------------");
//            System.out.println(e.getLocalizedMessage()); //除以零

//            System.out.println("------------- e.getStackTrace() --------------");
//            System.out.println(e.getStackTrace()); //[Ljava.lang.StackTraceElement;@a8a5f591

//            System.out.println("------------- e.getSuppressed() --------------");
//            System.out.println(e.getSuppressed()); //[Ljava.lang.Throwable;@3a41cafa

            System.out.println("---====================== 日志 =======================---");
            logger.error("日志: 1-{},2-{},3-{}", "yi", "er", "san", e);



        }





    }
}
