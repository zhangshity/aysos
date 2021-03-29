package com.zcy.thread._9__volatile;

import java.util.concurrent.TimeUnit;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《volatile》 关键字详解
 * @ Date: Created in 23:27 2021/3/22
 * @ Modified: By:
 * <p> * Premise:
 * <p> -- Java的内存模型 JMM (Java Memory Model)
 * <p> --- 并发编程，为了保证数据的安全，需要满足以下三个特性：
 * <p>      a.原子性 是指在一个操作中就是cpu不可以在中途暂停然后再调度，既不被中断操作，要不执行完成，要不就不执行。
 * <p>      b.可见性 是指当多个线程访问同一个变量时，一个线程修改了这个变量的值，其他线程能够立即看得到修改的值。
 * <p>      c.有序性 即程序执行的顺序按照代码的先后顺序执行。
 * <p>     缓存一致性问题其实就是可见性问题。而处理器优化是可以导致原子性问题的。指令重排即会导致有序性问题。
 *

 * <p>
 * <p> 1.保证可见性(不同线程对同一变量操作的内存可见性)
 * <p> 2.不保证原子性
 * <p> 3.禁止重排序
 */
public class VolatileTest {

    private static int i = 0;
    private static volatile int j = 0; //volatile保证多线程操作下的内存可见性


    public static void main(String[] args) throws InterruptedException {

        new Thread(() ->{
            while (i == 0) {
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        },"A").start();


        new Thread(() ->{
            while (j == 0) {
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        },"B").start();


        
        TimeUnit.SECONDS.sleep(3);

        System.out.println(Thread.currentThread().getName() + "改变赋值");
        i = 1;
        j = 1;
        System.out.println(Thread.currentThread().getName() + "运行结束");

    }
}
