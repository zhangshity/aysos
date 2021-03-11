package com.zcy.thread.Z_12_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《先打电话再发短信》不同对象,同一类锁，主线程顺序执行，先创建A线程,获取Student7类锁,执行,等待4秒
 *                                      ,睡1秒,                  创建B线程,获取Student7对象锁,执行
 * @ Date: Created in 17:02 2021/3/11
 * @ Modified: By:
 *
 * 同一对象，对象锁和类锁
 */
public class Lock7 {
    public static void main(String[] args) throws InterruptedException {
        Student7 student = new Student7();

        new Thread(() -> {
            student.msg();
        }, "A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            student.call();
        }, "B").start();

    }
}

class Student7 {
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


