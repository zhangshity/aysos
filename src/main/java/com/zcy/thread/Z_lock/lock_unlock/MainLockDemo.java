package com.zcy.thread.Z_lock.lock_unlock;

public class MainLockDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableImpl(), "t1");
        Thread thread2 = new Thread(new RunnableImpl(), "t2");
        Thread thread3 = new Thread(new RunnableImpl(), "t3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
