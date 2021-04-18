package com.zcy.spring.ioc.helloworld;

public class HelloWorld {
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void say(){
        System.out.println(msg);
    }

}
