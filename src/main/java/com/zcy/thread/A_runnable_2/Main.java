package com.zcy.thread.A_runnable_2;

public class Main {
    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        MyRunnable2 myRunnable2 = new MyRunnable2();
        MyRunnable3 myRunnable3 = new MyRunnable3();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable2);
        Thread t3 = new Thread(myRunnable3);
        t1.start();
        t2.start();
        t3.start();
    }
}
