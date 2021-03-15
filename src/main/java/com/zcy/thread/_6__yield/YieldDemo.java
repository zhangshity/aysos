package com.zcy.thread._6__yield;

import java.text.SimpleDateFormat;
import java.util.Date;

public class YieldDemo {
    public static void main(String[] args) throws InterruptedException {

        //线程逻辑
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running!" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                for (int i = 0; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ">> " + i);
                    if (i == 5) {
                        Thread.yield(); //让出CPU请求(暗示,并不会一定让出,取决于调度器)
                    }
                }
            }
        };

        //主线程逻辑
        Thread t1 = new Thread(runnable, "A");
        Thread t2 = new Thread(runnable, "B");
        t1.start();
        t2.start();

    }
}
