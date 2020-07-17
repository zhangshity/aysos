package com.zcy.thread_concurrent.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《Callable接口的基本使用》
 * @ Date: Created in 15:09 2020/7/14
 * @ Modified: By:
 * <p>
 * <p> Callable位于J.U.C包下 (可以理解为Runnable的高级版)
 */
public class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        //线程命名
        Thread.currentThread().setName("MyCallable");
        System.out.println(Thread.currentThread().getName());
        return "myCallable return";
    }

    public static void main(String[] args) {
        //实现Callable创建对象实现类
        MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask(myCallable);

        //启动线程
        new Thread(futureTask).start();

        //获得返回值
        try {
            System.out.println("MyCallable返回值: " + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
