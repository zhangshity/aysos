package com.zcy.thread_concurrent._4__3juc_tool.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class DemoStartFlag {

    private static final int THREADS_COUNT = 100;

    public static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREADS_COUNT; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await(); // 线程在阻塞，当计数器==0，就唤醒往下执行。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("[" + Thread.currentThread().getName() + "] 开始执行……");
            }).start();
        }


        Thread.sleep(1000);

        // 计数器清零
        countDownLatch.countDown();


    }
}
