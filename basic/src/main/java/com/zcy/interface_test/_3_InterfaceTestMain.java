package com.zcy.interface_test;

public class _3_InterfaceTestMain {

    public static void main(String[] args) {
        //--------------- 普通调用 ---------------
        System.out.println(_1_InterfaceTest.var1); // 没有修饰符 变量
        System.out.println(_1_InterfaceTest.var2); // public修饰 变量
        System.out.println(_1_InterfaceTest.var3); // static 变量
        System.out.println(_1_InterfaceTest.var4); // final 变量
        System.out.println(_1_InterfaceTest.var5); // public static 变量
        System.out.println(_1_InterfaceTest.var6); // public final 变量
        System.out.println(_1_InterfaceTest.var7); // public static final 变量

        _1_InterfaceTest interfaceTest = new _2_InterfaceTestImpl();
        String method1 = interfaceTest.method1(); // 没有写public 和 abstract的方法
        String method2 = interfaceTest.method2(); // 只写public的方法
        String method3 = interfaceTest.method3(); // 只写abstract的方法
        String method4 = interfaceTest.method4(); // 写public 和 abstract的方法
        System.out.println("\n" + method1 + "\n" + method2 + "\n" + method3 + "\n" + method4);


        //--------------- default调用 ---------------
        _1_InterfaceTest in = new _2_InterfaceTestImpl();
        String defaultMethod = in.defaultMethod(); // interface default method
        System.out.println(defaultMethod);


        _1_InterfaceTest inOverrideDefault = new _1_InterfaceTest() {
            @Override
            public String method1() {
                return null;
            }

            @Override
            public String method2() {
                return null;
            }

            @Override
            public String method3() {
                return null;
            }

            @Override
            public String method4() {
                return null;
            }

            @Override
            public String defaultMethod() {
                return "这是重写的default方法";
            }
        };
        System.out.println(inOverrideDefault.defaultMethod()); // 这是重写的default方法


        //--------------- static调用 ---------------
        String staticMethod = _1_InterfaceTest.staticMethod(); // interface static method
        System.out.println(staticMethod);
    }
}
