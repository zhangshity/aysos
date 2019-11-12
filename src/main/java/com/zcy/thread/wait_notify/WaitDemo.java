package com.zcy.thread.wait_notify;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitDemo {

    //主函数
    public static void main(String[] args) throws InterruptedException {

        //定义一个对象,模拟锁
        Object objectLock = new Object();

        //定义线程A run()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程A在等待锁 " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                synchronized (objectLock) {
                    try {
                        System.out.println("线程A得到锁 " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        Thread.sleep(10);
                        System.out.println("线程A sleep() 10ms " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

                        System.out.println("线程A - objectLock对象wait()使线程A 让出CPU,释放了锁,进入等待队列 " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        //1.释放锁 2.进入等待队列 3.让出cpu
                        objectLock.wait();
//                        objectLock.wait(5000);
                        /**
                         * 从等待队列(释放锁且不正获得锁)进入锁池(争抢锁)
                         * 需要o.wait(1000)时间到,或者o.notify()、o.notifyAll()方法
                         */

                        System.out.println("线程A run() 完成 " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //主线程休眠100ms,保证线程A先于线程B运行
        Thread.sleep(100);

        //定义线程B run()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程B在等待锁 " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                synchronized (objectLock) {
                    try {
                        System.out.println("线程B得到锁 " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        Thread.sleep(10);
                        System.out.println("线程B sleep() 10ms " + new SimpleDateFormat("HH:mm:ss").format(new Date()));


                        objectLock.notify();
//                        objectLock.notifyAll();
                        System.out.println(("线程B - objectLock对象notify()通知 等待队列中 等待此锁的线程,抢占CPU,抢占锁 " + new SimpleDateFormat("HH:mm:ss").format(new Date())));
                        /**
                         * notify()和notifyAll()区别:
                         *  notify()随机通知等待队列中的一个线程,notifyAll()通知等待队列中所有的线程
                         */


                        System.out.println("线程B run() 完成 " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }


}
