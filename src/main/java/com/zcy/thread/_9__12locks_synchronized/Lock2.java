package com.zcy.thread._9__12locks_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《先发短信再打电话》同一对象锁，主线程顺序执行，先创建A线程,获取对象锁,执行,等待4秒
 *                                      ,睡1秒,            创建B线程,等待A线程释放对象锁
 * @ Date: Created in 17:02 2021/3/11
 * @ Modified: By:
 *
 * 单一对象对象锁
 */
public class Lock2 {
    public static void main(String[] args) throws InterruptedException {
        Student2 student = new Student2();

        new Thread(() -> {
            student.msg();
        }, "A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            student.call();
        }, "B").start();

    }
}

class Student2 {
    public synchronized void msg() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }
}


