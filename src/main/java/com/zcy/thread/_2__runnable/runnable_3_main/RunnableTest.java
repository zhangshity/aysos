package com.zcy.thread._2__runnable.runnable_3_main;

public class RunnableTest {
    public static void main(String[] args) {

        // 1.传统匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":线程启动了!");
            }
        }).start();


        // 2.lambda方式匿名内部类
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":线程启动了!");
        }).start();


    }
}
