package com.zcy.thread._11__12locks_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《先发短信在打电话》不同对象,同一类锁，主线程顺序执行，先创建A线程,获取Student6类锁,执行,等待4秒
 *                                      ,睡1秒,                  创建B线程,等待A线程释放Student6类锁,执行
 * @ Date: Created in 17:02 2021/3/11
 * @ Modified: By:
 *
 * 不同对象类锁
 */
public class Lock6 {
    public static void main(String[] args) throws InterruptedException {
        Student6 student1 = new Student6();
        Student6 student2 = new Student6();

        new Thread(() -> {
            student1.msg();
        }, "A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            student2.call();
        }, "B").start();

    }
}

class Student6 {
    public static synchronized void msg() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }
}


