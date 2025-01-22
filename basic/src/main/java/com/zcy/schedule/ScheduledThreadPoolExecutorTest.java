package com.zcy.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {
    public static void main(String[] args) {
        // 创建一个 ScheduledThreadPoolExecutor，核心线程数为 2
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);


        // 延迟 1 秒后开始执行任务，之后每隔 2 秒执行一次
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService
                .scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Task1 is running at: " + System.currentTimeMillis());
                    }
                }, 1, 2, TimeUnit.SECONDS);


        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task2 is running at: " + System.currentTimeMillis());
            }
        }, 1, TimeUnit.SECONDS);


















        // 为了演示，让程序运行一段时间
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // 取消任务
        scheduledFuture.cancel(true);


        // 关闭 ScheduledExecutorService
        scheduledExecutorService.shutdown();
    }
}


