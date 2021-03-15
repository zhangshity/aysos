package com.zcy.thread._9__12locks_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《先发短信在打电话》同一对象,同一类锁，主线程顺序执行，先创建A线程,获取Student5类锁,执行,等待4秒
 *                                      ,睡1秒,                  创建B线程,等待A线程释放Student5类锁,执行
 * @ Date: Created in 17:02 2021/3/11
 * @ Modified: By:
 *
 * 类锁
 */
public class Lock5 {
    public static void main(String[] args) throws InterruptedException {
        Student5 student = new Student5();

        new Thread(() -> {
            student.msg();
        }, "A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            student.call();
        }, "B").start();

    }
}

class Student5 {
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


