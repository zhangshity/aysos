package com.zcy.thread_concurrent._1__lock.lock_unlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainLockDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableImpl(), "t1");
        Thread thread2 = new Thread(new RunnableImpl(), "t2");
        Thread thread3 = new Thread(new RunnableImpl(), "t3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}




class RunnableImpl implements Runnable {

    //定义共享票资源
    private static int ticket = 100;

    //1.在成员位置创建一个ReentrantLock对象
    static Lock lock = new ReentrantLock(true);

    //设置线程任务: 卖票
    @Override
    public void run() {
        //使用死循环,让卖票重复的执行
        while (true) {
            //2.在可能出现线程安全问题的代码前,调用Lock接口中的方法lock获取锁对象
            lock.lock();
            //判断票是否大于0
            if (ticket > 0) {
                //为了提高线程安全问题出现的几率,让程序睡眠10毫秒
                try {
                    //可能会产生异常的代码
                    Thread.sleep(100);
                    //进行卖票 ticket--
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票!");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace(); //异常的处理逻辑
                } finally {
                    //一定会执行的代码,一般用于资源释放(资源回收)
                    //3.在可能出现线程安全问题的代码后,调用Lock接口中的方法unlock释放锁对象
                    lock.unlock();//无论程序是否有异常,都让锁对象释放掉,节约内存,提高程序的效率
                }
            }
        }
    }
}
