package com.zcy.interface_test;

public class _2_InterfaceTestImpl implements _1_InterfaceTest {

    @Override
    public String method1() {
        return "没有写public 和 abstract的方法";
    }

    @Override
    public String method2() {
        return "只写public的方法";
    }

    @Override
    public String method3() {
        return "只写abstract的方法";
    }

    @Override
    public String method4() {
        return "写public 和 abstract的方法";
    }

    public String implMethod() {
        return "实现类自己的方法！";
    }

}
