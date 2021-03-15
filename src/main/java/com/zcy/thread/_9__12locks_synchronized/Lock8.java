package com.zcy.thread._9__12locks_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《先打电话再发短信》不同对象,同一类锁，主线程顺序执行，先创建A线程,获取Student8类锁,执行,等待4秒
 *                                      ,睡1秒,                  创建B线程,获取student2对象锁,执行
 * @ Date: Created in 17:02 2021/3/11
 * @ Modified: By:
 *
 * 不同对象，对象锁和类锁
 */
public class Lock8 {
    public static void main(String[] args) throws InterruptedException {
        Student8 student1 = new Student8();
        Student8 student2 = new Student8();

        new Thread(() -> {
            student2.msg();
        }, "A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            student2.call();
        }, "B").start();

    }
}

class Student8 {
    public static synchronized void msg() {
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


