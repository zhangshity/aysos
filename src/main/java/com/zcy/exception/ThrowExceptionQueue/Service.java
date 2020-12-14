package com.zcy.exception.ThrowExceptionQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service {

    private static final Logger logger = LoggerFactory.getLogger(Service.class);


    //service层
    public String serviceMethod() throws Exception {
        //System.out.println(" sout : service method");
        String result = this.servicePrivateMethod();           //service 写不写 try catch  -controller都能捕获到,
        return result;
    }


    //service层private方法
    private String servicePrivateMethod() throws Exception {
        //System.out.println(" sout : service private method");
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException("Service层异常: 1/0 ", e);
            //throw e;
            //logger.error("Service 层捕获的异常", e);
        }
        return "service private method !!!!!!!!! Result";
    }
}
