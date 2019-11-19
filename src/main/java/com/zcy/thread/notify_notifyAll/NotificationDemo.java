package com.zcy.thread.notify_notifyAll;

import sun.awt.windows.ThemeReader;

public class NotificationDemo {

    private volatile boolean go = false;

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        final NotificationDemo test = new NotificationDemo();

        //wait() thread
        Runnable waitTask = new Runnable() {
            @Override
            public void run() {
                try {
                    test.shouldGo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "waitTask已经完成");//因为shouldGo()中wait()会让线程等待，走到这步时一定一定完成
            }
        };

        //notify() notifyAll() thread
        Runnable notifyTask = new Runnable() {
            @Override
            public void run() {
                test.go();
                System.out.println(Thread.currentThread().getName() + "notifyTask已经通知其他线程抢占锁");
            }
        };

        Thread t1 = new Thread(waitTask, "w1");
        Thread t2 = new Thread(waitTask, "w2");
        Thread t3 = new Thread(waitTask, "w3");
        Thread t4 = new Thread(waitTask, "w4");
        Thread t5 = new Thread(waitTask, "w5");
        Thread t6 = new Thread(waitTask, "w6");
        Thread t7 = new Thread(waitTask, "w7");

        Thread notifyThread = new Thread(notifyTask, "notifyThread");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

        Thread.sleep(200);

        notifyThread.start();


    }


    /**
     * shouldGo()方法 -wait()
     *
     * @throws InterruptedException
     */
    private synchronized void shouldGo() throws InterruptedException {
        while (go == false) {
            System.out.println(Thread.currentThread().getName() + "正在等待Notification对象");
            wait();
            System.out.println(Thread.currentThread().getName() + "已被唤醒");
        }
        go = false;
    }

    /**
     * go() 方法 -notify() notifyAll()
     */
    private synchronized void go() {
        while (go == false) {
            System.out.println(Thread.currentThread().getName() + "正在notify or notifyAll 线程进入锁池");
            go = true;
//            notify();
            notifyAll();

        }
    }


}
