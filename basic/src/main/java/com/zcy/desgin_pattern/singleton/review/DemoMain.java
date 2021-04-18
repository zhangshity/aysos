package com.zcy.desgin_pattern.singleton.review;

public class DemoMain {

    public static void main(String[] args) {

        //懒汉式创建
        SingletonLazy lazyInstance = SingletonLazy.getInstance();
        lazyInstance.showMessage();

        //饿汉式创建
        SingletonStarve starveInstance = SingletonStarve.getInstance();
        starveInstance.showMessage();

    }
}
