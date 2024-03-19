package com.zcy.thread_concurrent._3__callable;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        // --------------------------- FutureTask执行 ---------------------------
        System.out.println("----------------- FutureTask执行 --------------------");
        // 1.创建Callable对象 内部类
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Callable call() anonymous inner class";
            }
        });
        // 2.创建Callable对象 lambda
        FutureTask<String> futureTask2 = new FutureTask<>(() -> "Callable call() lambda");

        // 启动线程
        new Thread(futureTask).start();
        new Thread(futureTask2).start();

        // 获得返回值
        System.out.println(futureTask.get());
        System.out.println(futureTask2.get());


        // FutureTask包装Runnable和Callable的区别:
        // -> 线程执行FutureTask, runnable为构造参数,执行runnable的run()方法
        // -> 线程执行FutureTask, callable为构造参数,执行callable的call()方法
        //      FutureTask包装Callable，线程执行时调用FutureTask的run()方法，run()方法调用Callable的call()方法, 最终执行call()
        //      FutureTask包装Runnable，线程执行时调用FutureTask的run()方法，run()方法调用内部RunnableAdapter的call()方法, 此call()方法调用Runnable的run()方法, 最终执行run()
        //
        // ############################################################
        // FutureTask就是一个万金油，见runnable就run()，见callable就call()
        // ############################################################







        // --------------------------- 线程池执行 ---------------------------
        System.out.println("----------------- 线程池执行 --------------------");
        ExecutorService executorService = new ThreadPoolExecutor(8, 8, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1024));

        // 线程池执行runnable
        Future<?> runnable = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始执行 Runnable run() anonymous inner class");
            }
        });  // 内部把Runnable包装成了FutureTask ->

        // 线程池
        Future<String> callable = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("开始执行 Callable call() anonymous inner class");
                return "Callable call() anonymous inner class";
            }
        });

        Thread.sleep(3000);
        System.out.println(runnable.get());
        System.out.println(callable.get());
        executorService.shutdown();

        // 线程池执行submit
        //  -> 调用AbstractExecutorService.submit()
        //      -> 包装runnable或callable 成 FutureTask (FutureTask实现了RunnableFuture接口,RunnableFuture接口继承了Runnable和Future接口)
        //          -> 调用ThreadPoolExecutor.execute(Runnable) 执行
        //
        // ############################################################
        // 最终submit()还是执行了execute()方法,只是把runnable和callable包装成了FutureTask
        // ############################################################




    }
}
