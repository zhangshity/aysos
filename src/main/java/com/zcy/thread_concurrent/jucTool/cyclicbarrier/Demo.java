package com.zcy.thread_concurrent.jucTool.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ Author: chunyang.zhang
 * @ Description: 循环栅栏
 * @ Date: Created in 16:27 2020/5/16
 * @ Modified: By:
 */
public class Demo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙！");
        });

        for (int i = 0; i < 7; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    System.out.println("收集" + finalI + "号龙珠");

                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
