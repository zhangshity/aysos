package com.zcy.thread_concurrent.executor;

import java.util.concurrent.*;

/**
 * 线程池
 * 跟数据库连接池类似
 * 避免了线程的创建和销毁造成的额外开销
 *
 * <p> java.util.concurrent
 *
 * <p> Executor    负责现成的使用和调度的根接口
 * <p>    |--ExecutorService    线程池的主要接口
 * <p>          |--ThreadPoolExecutor    线程池的实现类
 * <p>          |--ScheduledExecutorService    接口，负责线程的调度
 * <p>              |--ScheduledThreadPoolExecutor    (extends ThreadPoolExecutor implements ScheduledExecutorService)
 * <p>
 * <p>
 * Executors工具类
 * 提供了创建线程池的方法
 */
public class ThreadPool {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        Future f1 = pool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                int result = 0;
                for (int i = 0; i < 10; i++) {
                    result += i;
                    System.out.println(Thread.currentThread().getName() + " " + result);
                }
                return result;
            }
        });

        System.out.println(f1.get());
        System.out.println(pool.isShutdown());

        pool.submit(() -> System.out.println(500));
        System.out.println(pool.isShutdown());

        pool.shutdown();
        System.out.println(pool.isShutdown());


    }


}
