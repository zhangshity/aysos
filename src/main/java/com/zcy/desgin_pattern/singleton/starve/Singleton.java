package com.zcy.desgin_pattern.singleton.starve;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 15:07 2018/12/7
 * @ Modified: By:
 */

public class Singleton {

    private Singleton() {
    }

    private static Singleton singleton;

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            return new Singleton();
        }
        return singleton;
    }

    public void showMessage() {
        System.out.println("懒汉单利模式,调用实例才会创建对象,省资源,但是synchronized会影响性能");
    }
}
