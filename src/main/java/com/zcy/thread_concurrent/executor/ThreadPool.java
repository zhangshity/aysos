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


    /**
     * 《Alibaba开发手册》 建议
     *
     * 1. 【强制】获取单例对象需要保证线程安全，其中的方法也要保证线程安全。
     * 说明：资源驱动类、工具类、单例工厂类都需要注意。
     *
     * 2. 【强制】创建线程或线程池时请指定有意义的线程名称，方便出错时回溯。
     * 正例：
     * public class TimerTaskThread extends Thread {
     *       public TimerTaskThread() {
     *             super.setName("TimerTaskThread");
     *             ...
     *       }
     * }
     *
     * 3. 【强制】线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。 说明：使用线程池的好处是减少在创建和销毁线程上所消耗的时间以及系统资源的开销，解决
     * 资源不足的问题。如果不使用线程池，有可能造成系统创建大量同类线程而导致消耗完内存或 者“过度切换”的问题。
     *
     * 4. 【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样 的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
     * 说明：Executors 返回的线程池对象的弊端如下：
     * 1）FixedThreadPool 和 SingleThreadPool:   允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
     * 2）CachedThreadPool 和 ScheduledThreadPool:   允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Java的线程池工具类创建方式 (Alibaba不建议此种方式,而是用其原始的方式)
        ExecutorService p1 = Executors.newSingleThreadExecutor();
        ExecutorService p2 = Executors.newFixedThreadPool(5);

        ExecutorService p3 = Executors.newCachedThreadPool();
        ExecutorService p4 = Executors.newScheduledThreadPool(10);

        // ====================================================================================================================================================================================
        // 原始的线程池创建方式 (Alibaba建议)
        // ThreadPoolExecutor THREADPOOL = new ThreadPoolExecutor(
        //    int corePoolSize,                     //corePoolSize：   线程池维护线程的最少数量
        //    int maximumPoolSize,                  //maximumPoolSize：线程池维护线程的最大数量
        //    long keepAliveTime,                   //keepAliveTime：  线程池维护线程所允许的空闲时间
        //    TimeUnit unit,                        //unit：           线程池维护线程所允许的空闲时间的单位 (NANOSECONDS、MICROSECONDS、MILLISECONDS、SECONDS、MINUTES、HOURS,DAYS)
        //    BlockingQueue<Runnable> workQueue,    //workQueue：      线程池所使用的阻塞队列 (ArrayBlockingQueue、LinkedBlockingQueue、PriorityBlockingQueue、DelayQueue、SynchronousQueue)
        //    ThreadFactory threadFactory,          //threadFactory：  线程池工厂
        //    RejectedExecutionHandler handler      //handler：        线程池对拒绝任务的处理策略|--ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
        // );                                                                                 |--ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
        //                                                                                   |--ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
        //                                                                                   |--ThreadPoolExecutor.CallerRunsPolicy：只要线程池不关闭，该策略直接在调用者线程中，运行当前被丢弃的任务
        //                                                                                   |--自己定义拒绝策略，实现RejectedExecutionHandler接口


        // Alibaba建议的线程池创建方式
        // 1.构造函数1,未包含 ThreadFactory线程工厂 和 RejectedExecutionHandler拒绝策略
        ExecutorService p5 = new ThreadPoolExecutor(10, 10, 1000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));

        // 2.构造函数2,只包含 ThreadFactory线程工厂
        ExecutorService p6 = new ThreadPoolExecutor(10, 10, 1000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5), r -> {
            return new Thread(() -> Thread.currentThread().setName("我是一个override的ThreadFactory的自定义线程工程方法"));
        });

        // 3.构造函数3,只包含  RejectedExecutionHandler拒绝执行策略
        ExecutorService p7 = new ThreadPoolExecutor(10, 10, 1000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.DiscardPolicy());

        // 4.构造函数4,全部参数
        ExecutorService p8 = new ThreadPoolExecutor(10, 10, 1000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5), r -> {
            return new Thread(() -> Thread.currentThread().setName("我是一个override的ThreadFactory的自定义线程工程方法"));
        }, new ThreadPoolExecutor.DiscardPolicy());















        // ============================== 旧例子 ==================================
        ExecutorService pool = Executors.newFixedThreadPool(5);

        Future f1 = pool.submit(new Callable<Object>() {
            @Override
            public Object call() {
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
