package com.zcy.thread._4__notify_notifyAll;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyNotificationDemo {
    public static void main(String[] args) throws InterruptedException {

        final MyNotificationDemo lock = new MyNotificationDemo();

        //wait()线程
        Runnable wait = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "~正在执行 " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                synchronized (lock) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "|锁对象wait(),此线程进入等待队列 " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait(5000);
                        System.out.println(Thread.currentThread().getName() + ">>> 完成 " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //notify()线程
        Runnable notify = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    lock.notify();
//                    lock.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "|锁对象notify()notifyAll(),等待队列中的其他线程进入锁池 " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                }
            }
        };

        Thread t1 = new Thread(wait, "Thread-W1");
        Thread t2 = new Thread(wait, "Thread-W2");
        Thread t3 = new Thread(wait, "Thread-W3");
        Thread t4 = new Thread(wait, "Thread-W4");
        Thread t5 = new Thread(wait, "Thread-W5");
        Thread t6 = new Thread(wait, "Thread-W6");
        Thread t7 = new Thread(wait, "Thread-W7");
        Thread notifyThread = new Thread(notify, "Thread-N1");

        //等待线程启动
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

        //主线程休眠1s
        Thread.sleep(1000);

        //通知线程启动
        notifyThread.start();


    }
}
