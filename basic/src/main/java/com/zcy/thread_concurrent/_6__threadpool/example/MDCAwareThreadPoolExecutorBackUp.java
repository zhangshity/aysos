package com.zcy.thread_concurrent._6__threadpool.example;

import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * MDC依赖线程池
 */
public class MDCAwareThreadPoolExecutorBackUp extends ThreadPoolExecutor {

    // -----------------------------------------------------------------------
    // ~ Constructors

    public MDCAwareThreadPoolExecutorBackUp(int corePoolSize,
                                            int maximumPoolSize,
                                            long keepAliveTime,
                                            TimeUnit unit,
                                            BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MDCAwareThreadPoolExecutorBackUp(int corePoolSize,
                                            int maximumPoolSize,
                                            long keepAliveTime,
                                            TimeUnit unit,
                                            BlockingQueue<Runnable> workQueue,
                                            ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MDCAwareThreadPoolExecutorBackUp(int corePoolSize,
                                            int maximumPoolSize,
                                            long keepAliveTime,
                                            TimeUnit unit,
                                            BlockingQueue<Runnable> workQueue,
                                            RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MDCAwareThreadPoolExecutorBackUp(int corePoolSize,
                                            int maximumPoolSize,
                                            long keepAliveTime,
                                            TimeUnit unit,
                                            BlockingQueue<Runnable> workQueue,
                                            ThreadFactory threadFactory,
                                            RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }


    // -----------------------------------------------------------------------
    // MDC context propagation

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        // Capture parent MDC context
        Map<String, String> mdcContext = MDC.getCopyOfContextMap();

        // Set the parent MDC context to the new thread
        if (mdcContext != null) {
            System.out.println("mdcContext: " + mdcContext);
            MDC.setContextMap(mdcContext);
        }

        System.out.println("beforeExecute");
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);

        // Clear MDC context after task execution
        MDC.clear();

        System.out.println("afterExecute");
    }

}
