package com.zcy.thread.Z_12_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《先发短信再打电话》无锁，主线程顺序执行，先创建A线程,睡1秒,创建线程B
 * @ Date: Created in 17:02 2021/3/11
 * @ Modified: By:
 *
 * 无锁
 */

public class Lock1 {
    public static void main(String[] args) throws InterruptedException {
        Student student = new Student();

        new Thread(() -> {
            student.msg();
        }, "A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            student.call();
        }, "B").start();

    }
}

class Student {
    public void msg() {
        System.out.println("发短信");
    }

    public void call() {
        System.out.println("打电话");
    }
}


