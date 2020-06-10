package com.zcy.exception.ThrowExceptionQueue;

public class Service {

    //service层
    public String serviceMethod() {
        System.out.println(" sout : service method");
        String result = null;

//        try {
//            result = this.servicePrivateMethod();
//        } catch (RuntimeException e) {
//            throw e;
//        }

        result = this.servicePrivateMethod();           //service 写不写 try catch  -controller都能捕获到,

        return result;
    }




    //service层private方法
    private String servicePrivateMethod() {
        System.out.println(" sout : service private method");
        try {
            int i = 1 / 0;
        } catch (RuntimeException e) {
            throw e;
        }
        return "service private method !!!!!!!!! Result";
    }
}
