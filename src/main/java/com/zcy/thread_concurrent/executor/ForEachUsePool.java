package com.zcy.thread_concurrent.executor;

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

public class ForEachUsePool {

    private static final Logger logger = LoggerFactory.getLogger(ForEachUsePool.class);

    private static final ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024));

    private static final ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        // 构造数据列表
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        logger.info("[{}] 构造数据列表 成功！ ",Thread.currentThread().getName());

        CountDownLatch countDownLatch = new CountDownLatch(list.size());

        // 线城池遍历处理
        list.forEach(integer -> {
            try {
                // 多线程并发执行
                executorService.execute(() -> {
                    try {
                        logger.info("[{}]!!!!!!!!!!!!!   {}",Thread.currentThread().getName(),integer);
                        concurrentHashMap.put(add(integer), "[null]");
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
        logger.info("   ~~~~~~~~~~~~~~~~~~  {}", concurrentHashMap);
    }


    private static String add(int i) {
        return String.valueOf(i) + " ---@****";
    }
}
