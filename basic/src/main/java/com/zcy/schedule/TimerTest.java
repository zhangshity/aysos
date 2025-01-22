package com.zcy.schedule;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        // 创建定时器对象：
        // 对象内涵一个线程对象，用于执行定时任务；
        // 对象内涵一个任务队列，用于存放定时任务；
        // 对象构造函数会start()内部线程，循环判断队列和定时任务的执行时间，到时间就执行
        Timer timer = new Timer();


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务执行了");
            }
        }, 1000, 2000);
    }
}
