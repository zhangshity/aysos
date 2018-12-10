package com.zcy.desgin_pattern.singleton.demo;


/**
 * @ Author: chunyang.zhang
 * @ Description:  单例模式demo
 * @ Date: Created in 14:13 2018/12/7
 * @ Modified: By:
 */
public class SingleObject {

    //创建 SingleObject 的一个对象
    private static SingleObject instance = new SingleObject();

    //让构造函数为 private，这样该类就不会被实例化
    private SingleObject() {
    }

    //获取唯一可用的对象
    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }

}
