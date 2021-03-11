package com.zcy.thread.Z_12_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《先打电话再发短信》不同对象锁，主线程顺序执行，先创建A线程,获取student1对象锁,执行,等待4秒
 *                                      ,睡1秒,            创建B线程,获取student2对象锁,执行
 * @ Date: Created in 17:02 2021/3/11
 * @ Modified: By:
 *
 * 不同对象对象锁
 */
public class Lock3 {
    public static void main(String[] args) throws InterruptedException {
        Student3 student1 = new Student3();
        Student3 student2 = new Student3();

        new Thread(() -> {
            student1.msg();
        }, "A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            student2.call();
        }, "B").start();

    }
}

class Student3 {
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


