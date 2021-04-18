package com.zcy.thread._2__runnable.runnable_1;

public class Main {
    public static void main(String[] args) {

        //实例化myRunnable线程类
        MyRunnable myRunnable = new MyRunnable();

        //因为Runnable只有run()方法，所以需要借助Thread类来启动此自定义线程
        Thread thread = new Thread(myRunnable);
        thread.start();


    }
}
