package com.zcy.exception.ThrowExceptionQueue;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

public class Controller {

    //controller层
    Service service = new Service();

    public String controllerMethod()   {
        System.out.println(" sout: controller method");

        String result = null;
        try {
            result = service.serviceMethod();
        } catch (RuntimeException e) {
            System.out.println("==============================");
            System.out.println("final controller catch block ");
            System.out.println("|| : > " + e);
            System.out.println("==============================");
        }

//        result = service.serviceMethod();


        return result;
    }

}
