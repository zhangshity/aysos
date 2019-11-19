package com.zcy.thread.A_thread_1;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread线程,线程名 >>> "
                + Thread.currentThread().getName());
    }
}
