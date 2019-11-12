package com.zcy.java1_8NewFunction.default_iterface_method;

/**
 * @ Author: chunyang.zhang
 * @ Description: <>1.8新特性——接口默认实现方法</>
 * @ Date: Created in 16:54 2019/11/6
 * @ Modified: By:
 */
public interface Person {

    //默认无修饰(实际为public,abstract)
    void doSomething();

    //public修饰(可以省去,编译器提示redundant)
    public void doPublicSomething();

    //public,abstract修饰(均可以省去,编译器均提示redundant)
    public abstract void doAbstractSomething();

    //static修饰(需要方法体)
    public static void doStaticSomething() {
        System.out.println("static method in Person Class");
    }

    //默认方法,不需要实现类实现的方法
    default void doDefaultSomething() {
        System.out.println("default method in interface");
    }

}
