package com.zcy.thread_concurrent._6__threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ForEachUsePool {

    private static final Logger logger = LoggerFactory.getLogger(ForEachUsePool.class);

    private static final ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024));

    private static final ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();


    private static final AtomicInteger count = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        // 构造数据列表
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        logger.info("[{}] 构造数据列表 成功！ ",Thread.currentThread().getName());

        CountDownLatch countDownLatch = new CountDownLatch(list.size());

        // 线城池遍历处理
        list.forEach(i -> {
            try {
                // 多线程并发执行
                executorService.execute(() -> {
                    try {
                        logger.info("[{}]!!!!!!!!!!!!!   {}",Thread.currentThread().getName(),i);
                        int affectedRows = add(i);
                        count.addAndGet(affectedRows);
                        concurrentHashMap.put(affectedRows == 1 ? i : 666666, "[null]");
                    } finally {
                        countDownLatch.countDown();
                    }
                });
            } catch (Exception e) {
                logger.error("？？？", e);
            }
        });


        countDownLatch.await();
        logger.info("--------------------------------------------------   [{}] 继续执行！！！！！ ------------------------------------------------------------------------------------- ",
                Thread.currentThread().getName());


        executorService.shutdown();


        Thread.sleep(1000);
        logger.info("   ~~~~~ 统计数量(影响行数){}~~~~~~~~~~~~~  {}", count, concurrentHashMap);
    }


    private static int add(int i) {
        if (i % 10 == 0) {
            return 1;
        }
        return 0;
    }
}
