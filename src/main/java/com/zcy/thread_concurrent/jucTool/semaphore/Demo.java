package com.zcy.thread_concurrent.jucTool.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: chunyang.zhang
 * @ Description: 信号量
 * @ Date: Created in 16:29 2020/5/16
 * @ Modified: By:
 */
public class Demo {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(finalI + "号车停车");

                    TimeUnit.SECONDS.sleep(3);

                    System.out.println(finalI + "号车离开车位");
                    semaphore.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

    }
}
