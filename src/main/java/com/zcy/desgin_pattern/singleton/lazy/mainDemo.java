package com.zcy.desgin_pattern.singleton.lazy;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:34 2018/12/7
 * @ Modified: By:
 */

public class mainDemo {

    public static void main(String[] args) {

        //不合法构建,因为构建参数是私有的
        //Singleton singleton = new Singleton();
        //singleton.showMessage();

        com.zcy.desgin_pattern.singleton.lazy.Singleton singletonInstance = com.zcy.desgin_pattern.singleton.lazy.Singleton.getInstance();

        singletonInstance.showMessage();

    }


}
