package com.zcy.thread_concurrent._6__threadpool.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class _MDCThreadPoolTest {
    private static final ExecutorService THREAD_POOL = new MDCAwareThreadPoolExecutor(
            new ThreadPoolExecutor(
                    Runtime.getRuntime().availableProcessors(),
                    Runtime.getRuntime().availableProcessors(),
                    0L,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(4096)
            )
    );


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            THREAD_POOL.execute(() -> System.out.println("Hello, world!"));
        }


        THREAD_POOL.shutdown();
    }
}
