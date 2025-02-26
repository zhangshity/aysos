package com.zcy.thread._13_semaphore;

import java.util.concurrent.Semaphore;

/**
 * 两线程交替打印1-100  信号量
 */
public class Test {
    private static int num = 1;
    private static final Semaphore semaphoreA = new Semaphore(1);
    private static final Semaphore semaphoreB = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> {
            while (num <= 100) {
                try {
                    semaphoreA.acquire();
                    System.out.println("Thread-A: " + num++);
                    semaphoreB.release();
                } catch (InterruptedException e) {
                }
            }
        }, "Thread-A").start();

        new Thread(() -> {
            while (num <= 100) {
                try {
                    semaphoreB.acquire();
                    System.out.println("Thread-B: " + num++);
                    semaphoreA.release();
                } catch (InterruptedException e) {
                }
            }
        }, "Thread-B").start();
    }
}
