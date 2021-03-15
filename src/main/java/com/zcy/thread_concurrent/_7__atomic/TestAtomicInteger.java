package com.zcy.thread_concurrent._7__atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {
    private static final int THREADS_COUNT = 100;

    public static int count = 0;
    public static volatile int countVolatile = 0;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void increase() {
        count++;
        countVolatile++;
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        // 定义线程数组
        Thread[] threadArray = new Thread[THREADS_COUNT];

        // 遍历线程数组
        for (Thread t : threadArray) {
            // 定义线程内容
            t = new Thread(() -> {
                for (int y = 0; y < 1000; y++) {
                    increase();
                }
            });

            // 启动线程
            t.start();
        }


        // 主线程休眠50ms,等待所有线程处理完成
        Thread.sleep(50);

        // ==================== Print Result ====================
        System.out.println(count);                    //线程不安全
        System.out.println(countVolatile);            //线程不安全
        System.out.println(atomicInteger.get());      //线程安全
    }
}