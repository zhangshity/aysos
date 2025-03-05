package com.zcy.thread_concurrent._7__atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 两线程交替打印1-100  AtomicInteger volatile
 */
public class Test {
    private static AtomicInteger num = new AtomicInteger(1);
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (num.get() <= 100) {
                if (flag) {
                    System.out.println("Thread-A: " + num.get());
                    num.incrementAndGet();
                    flag = false;
                }
            }
        }, "Thread-A").start();

        new Thread(() -> {
            while (num.get() <= 100) {
                if (!flag) {
                    System.out.println("Thread-B: " + num.get());
                    num.incrementAndGet();
                    flag = true;
                }
            }
        }, "Thread-B").start();
    }
}
