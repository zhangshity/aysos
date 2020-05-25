package com.zcy._extends.super_this;

public class Father {

    private int code;

    private String msg;

    public Father() {
    }

    protected Father(int code, String msg) {
        this.code = code;
        this.msg = msg;
        System.out.println("Father build constructor");
    }

    public void method1() {
        System.out.println("Father method1");
    }

    public void method2() {
        System.out.println("Father method2");
    }

}
