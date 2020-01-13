package com.zcy._extends;

public class Test {

    static class ClassA {

        private static int staticField = 10; //静态成员变量

        static {
            System.out.println("static A {}"); //静态代码段
        }


        private int normalField = 5; //成员变量

        {
            System.out.println("A {}"); //初始化代码段
        }


        public ClassA() {
            System.out.println("ClassA()"); //构造函数
        }
    }

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    static class ClassB extends ClassA {

        private static int staticField = 50; //子类静态成员变量

        static {
            System.out.println("static B {}"); //子类静态代码段
        }


        private int normalField = 25; //子类成员变量

        {
            System.out.println("B {}"); //子类初始化代码段
        }


        public ClassB() {
            System.out.println("ClassB()"); //子类构造函数
        }
    }


    //=======================================================
    public static void main(String[] args) {
        new ClassB();
    }

}
