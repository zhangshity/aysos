package com.zcy.thread._9__12locks_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《先hello再发短信》无锁和对象锁，主线程顺序执行，先创建A线程,获取student对象锁,执行,等待4秒
 *                                      ,睡1秒,            创建B线程,无锁,执行
 * @ Date: Created in 17:02 2021/3/11
 * @ Modified: By:
 *
 * 无锁和对象锁
 */
public class Lock4 {
    public static void main(String[] args) throws InterruptedException {
        Student4 student = new Student4();

        new Thread(() -> {
            student.msg();
        }, "A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            student.hello();
        }, "B").start();

    }
}

class Student4 {
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

    public void hello() {
        System.out.println("Hello");
    }
}


