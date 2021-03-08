package com.zcy.thread_concurrent.jucTool.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @ Author: chunyang.zhang
 * @ Description: 倒计时闩
 * @ Date: Created in 16:27 2020/5/16
 * @ Modified: By:
 */
public class DemoCount {
    private static final int THREADS_COUNT = 100;

    public static int count = 0;
    public static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void increase() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < THREADS_COUNT; i++) {
            new Thread(() -> {
                for (int y = 0; y < 1000; y++) {
                    increase();
                }
                countDownLatch.countDown();
            }).start();
        }



        Thread.sleep(100);
        countDownLatch.await(); // 主线程在阻塞，当计数器==0，就唤醒主线程往下执行。


        // 打印结果
        System.out.println(count);
    }

}
