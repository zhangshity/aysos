package com.zcy.thread.Z_synchronized;

public class SynDemoMain {

    public static void main(String[] args) {

        SynThread synThread = new SynThread();//同一个线程对象 (其为对象锁)

        Thread a_t1 = new Thread(synThread, "A_t1");
        Thread a_t2 = new Thread(synThread, "A_t2");
        Thread b_t1 = new Thread(synThread, "B_t1");
        Thread b_t2 = new Thread(synThread, "B_t2");
        Thread c_t1 = new Thread(synThread, "C_t1");
        Thread c_t2 = new Thread(synThread, "C_t2");

        a_t1.start();
        a_t2.start();
        b_t1.start();
        b_t2.start();
        c_t1.start();
        c_t2.start();
    }
}
