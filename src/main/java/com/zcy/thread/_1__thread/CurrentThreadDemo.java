package com.zcy.thread._1__thread;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《最基本的多线程展示-只有main函数》
 * @ Date: Created in 14:13 2019/11/9
 * @ Modified: By:
 * ==================================================
 * 程序展示只有主函数的线程
 * 其实JVM是多线程运行的(GC垃圾回收线程)
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {

        //native static方法 currentThread(),获得当前线程类引用
        Thread currentThread = Thread.currentThread();  // 获取当前线程

        //线程类getName()方法,获取线程名称
        String threadName = currentThread.getName();  // 当前线程,获取名称

        System.out.println(threadName);  // 打印名称
    }
}
