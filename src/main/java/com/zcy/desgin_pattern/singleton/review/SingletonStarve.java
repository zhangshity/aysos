package com.zcy.desgin_pattern.singleton.review;

import com.zcy.desgin_pattern.singleton.starve.Singleton;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 10:31 2018/12/10
 * @ Modified: By:
 */

public class SingletonStarve {

    //私有constructor
    private SingletonStarve() {
    }

    //私有实例化
    private static SingletonStarve singletonStarve = new SingletonStarve();

    //唯一暴露接口
    public static SingletonStarve getInstance() {
        return singletonStarve;
    }

    //实际使用方法
    public void showMessage() {
        System.out.println("SingletonStarve实例的show方法");
    }


}
