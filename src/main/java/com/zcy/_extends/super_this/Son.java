package com.zcy._extends.super_this;

public class Son extends Father {

    public Son() {
    }

    protected Son(int code, String msg) {
        super(code, msg);
    }

    public void method1() {
        System.out.println("Son method1");
    }


    public void super2thisTest() {
        this.method1();
        super.method1();
        this.method2();
        super.method2();
    }
}
