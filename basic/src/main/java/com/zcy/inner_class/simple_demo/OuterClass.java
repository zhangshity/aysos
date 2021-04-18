package com.zcy.inner_class.simple_demo;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《内部类的加载顺序 - 延迟加载》
 * @ Date: Created in 23:29 2021/3/23
 * @ Modified: By:
 */
public class OuterClass {

    static {
        System.out.println("外部类的静态代码块 outer | static code-block");
    }

    {
        System.out.println("外部类的普通代码块 outer | code-block");
    }

    public OuterClass() {
        System.out.println("外部类的构造方法 outer | constructor");
    }

    private void outMethod() {
        System.out.println("外部类的普通方法 outer | method");
        System.out.println("延迟加载->");

        StaticInnerClass staticInnerClass = new StaticInnerClass();
        InnerClass innerClass = new InnerClass();
    }

    // ======================= 内部类 Inner Class =======================
    public class InnerClass {
        // static {                                     // Inner classes cannot have static declarations
        //     System.out.println("内部类的静态代码块 inner | static code-block");
        // }

        {
            System.out.println("内部类的普通代码块 inner | code-block");
        }

        InnerClass() {
            System.out.println("内部类的构造方法 inner | constructor");
        }

        // public static void staticInnerMethod(){      // Inner classes cannot have static declarations
        //     System.out.println("内部类的静态方法 inner | static method");
        // }

        public void innerMethod() {
            System.out.println("内部类的普通方法 inner | method");
        }
    }

    // ======================= 静态内部类 Static Inner Class =======================
    public static class StaticInnerClass {
        static {
            System.out.println("静态内部类的静态代码块 static inner | static code-block");
        }

        {
            System.out.println("静态内部类的普通代码块 static inner | code-block");
        }

        StaticInnerClass() {
            System.out.println("静态内部类的构造方法 static inner | constructor");
        }

        public static void staticInnerMethod() {
            System.out.println("静态内部类的静态方法 static inner | static method");
        }

        public void innerMethod() {
            System.out.println("静态内部类的普通方法 static inner | method");
        }
    }


    /**
     * <p>Main 主函数
     * <p>!!!!*=#*=#*=#*=#*=#*=#*=#*=#!!!! 测试内部类的运行顺序 !!!!*=#*=#*=#*=#*=#*=#*=#*=#!!!!
     */
    public static void main(String[] str) {
        System.out.println("===== 主函数执行 new 外部类 ====");

//        OuterClass outerClass = new OuterClass(); // 只有外部类，内部类均不运行
        /**
         * 外部类的静态代码块 outer | static code-block
         * ===== 主函数执行 new 外部类 ====
         * 外部类的普通代码块 outer | code-block
         * 外部类的构造方法 outer | constructor
         */

//        StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass(); // 直接调用静态内部类
        /**
         * 外部类的静态代码块 outer | static code-block
         * ===== 主函数执行 new 外部类 ====
         * 静态内部类的静态代码块 static inner | static code-block
         * 静态内部类的普通代码块 static inner | code-block
         * 静态内部类的构造方法 static inner | constructor
         */

//        OuterClass outerClass = new OuterClass(); // 先实例化外部类,调用静态内部类(内部类同理,只是没有静态代码块)
//        outerClass.outMethod();    //(StaticInnerClass staticInnerClass = new StaticInnerClass();)
        /**
         * 外部类的静态代码块 outer | static code-block
         * ===== 主函数执行 new 外部类 ====
         * 外部类的普通代码块 outer | code-block
         * 外部类的构造方法 outer | constructor
         * 外部类的普通方法 outer | method
         * 延迟加载->
         * 静态内部类的静态代码块 static inner | static code-block
         * 静态内部类的普通代码块 static inner | code-block
         * 静态内部类的构造方法 static inner | constructor
         */

//        OuterClass outerClass = new OuterClass(); // 先实例化外部类,调用内部类(同静态,只是没有静态代码块)
//        outerClass.outMethod();    //(InnerClass innerClass = new InnerClass();)
        /**
         * 外部类的静态代码块 outer | static code-block
         * ===== 主函数执行 new 外部类 ====
         * 外部类的普通代码块 outer | code-block
         * 外部类的构造方法 outer | constructor
         * 外部类的普通方法 outer | method
         * 延迟加载->
         * 内部类的普通代码块 inner | code-block
         * 内部类的构造方法 inner | constructor
         */


        OuterClass outerClass = new OuterClass(); // 先实例化外部类,同时调用内部类和静态内部类
        outerClass.outMethod();    //(StaticInnerClass staticInnerClass = new StaticInnerClass();)
        //(InnerClass innerClass = new InnerClass();)
        // 打印两个内部类加载顺序 ，完全取决与调用先后顺序
        /**
         * 外部类的静态代码块 outer | static code-block
         * ===== 主函数执行 new 外部类 ====
         * 外部类的普通代码块 outer | code-block
         * 外部类的构造方法 outer | constructor
         * 外部类的普通方法 outer | method
         * 延迟加载->
         * 静态内部类的静态代码块 static inner | static code-block
         * 静态内部类的普通代码块 static inner | code-block
         * 静态内部类的构造方法 static inner | constructor
         * 内部类的普通代码块 inner | code-block
         * 内部类的构造方法 inner | constructor
         */

    }

}
