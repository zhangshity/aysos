package com.zcy.thread.runnable_1;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable线程,线程名 >>> " + Thread.currentThread().getName());
    }
}
