package com.zcy.thread._2__runnable.runnable_1;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable线程,线程名 >>> " + Thread.currentThread().getName());
    }
}
