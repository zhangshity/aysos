package com.zcy.desgin_pattern.singleton.review;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 10:02 2018/12/10
 * @ Modified: By:
 */

//lazy pattern
public class SingletonLazy {

    //私有constructor
    private SingletonLazy() {
    }

    //私有本类的引用
    private static SingletonLazy singletonLazy;

    //唯一对外的方法(!!!注:线程安全)
    public static synchronized SingletonLazy getInstance() {
        if (singletonLazy == null) {
            return new SingletonLazy();
        }
        return singletonLazy;
    }

    //实际使用的方法
    public void showMessage() {
        System.out.println("SingletonLazy实例的show方法");
    }


}
