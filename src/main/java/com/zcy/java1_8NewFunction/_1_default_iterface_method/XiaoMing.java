package com.zcy.java1_8NewFunction._1_default_iterface_method;

public class XiaoMing implements Person {
    @Override
    public void doSomething() {
        System.out.println("none");
    }

    @Override
    public void doPublicSomething() {
        System.out.println("public");
    }

    @Override
    public void doAbstractSomething() {
        System.out.println("abstract");
    }
}
