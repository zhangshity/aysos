package com.zcy.thread._2__runnable.runnable_2;

public class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
