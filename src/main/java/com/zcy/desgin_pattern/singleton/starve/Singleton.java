package com.zcy.desgin_pattern.singleton.starve;

/**
 * @ Author: chunyang.zhang
 * @ Description: 测试
 * @ Date: Created in 14:16 2018/12/7
 * @ Modified: By:
 */

public class Singleton {

    //私有空构造函数: 唯一的构造函数是私有的,只能被此类自己使用(注:因为创建了构造函数,默认构造函数不再创建)
    private Singleton() {
    }

    //Singleton singleton = new Singleton(); //必须静态加载,否则在调用唯一公开方法的时候无法外部实例化
    //此类自己创建自己的实例(私有化,不能外部调用)
    private static Singleton singleton = new Singleton();

    //唯一的对外暴露的方法
    public static Singleton getInstance() {
        return singleton;
    }

    public void showMessage() {
        System.out.println("This is Singleton Pattern,create by Singleton Class itself.");

    }













    //======错误方法==========================================================================
    // 不用静态的错误调用,造成死循环,无法实例化
//    private Singleton() {
//    }
//
//    Singleton singleton = new Singleton();
//
//    public Singleton getInstance() {
//        return singleton;
//    }

}
