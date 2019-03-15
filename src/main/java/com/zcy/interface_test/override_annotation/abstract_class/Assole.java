package com.zcy.interface_test.override_annotation.abstract_class;

public class Assole extends People {


    @Override
    public void doSomeShit() {
        System.out.println("doSomeShit...  @Override");
    }

    //@Override
    // 继承抽象方法,依然可以构建自己类的方法
    //但如果加了 @Override注解,就不能,其会校验
    public void doNothing() {
        System.out.println("doNothing... havn't @Override annotation");
    }
}
