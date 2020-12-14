package com.zcy.exception.ThrowExceptionQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    private final Service service = new Service();


    public String controllerMethod()   {
        //System.out.println(" sout: controller method");
        String result = null;
        try {
            result = service.serviceMethod();
        } catch (Exception e) {
            /*System.out.println("==============================");
            System.out.println("final controller catch block ");
            System.out.println("|| : > " + e);
            System.out.println("==============================");*/
            logger.error("Controller 层捕获的异常: ", e);
        }

        return result;
    }

}
