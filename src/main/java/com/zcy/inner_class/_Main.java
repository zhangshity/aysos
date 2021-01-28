package com.zcy.inner_class;

public class _Main {

    public static void main(String[] args) {

        // 成员内部类
        InnerClassTest innerClassTest = new InnerClassTest();
        innerClassTest.new Inner();

        System.out.println("======================== 直接创建内部类 =================");
        InnerClassTest.Inner inner1 = new InnerClassTest().new Inner();
        inner1.invokeOuterClass();




        // 静态内部类
        System.out.println("======================== 静态内部类 =================");
        StaticNestedClassTest.Inner staticInner = new StaticNestedClassTest.Inner();



        StaticNestedClassTest staticNestedClassTest = new StaticNestedClassTest();

    }

}
