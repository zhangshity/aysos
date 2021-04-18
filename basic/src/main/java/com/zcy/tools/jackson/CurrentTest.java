package com.zcy.tools.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zcy.tools.jackson.singleton.JacksonUtils;
import com.zcy.tools.jackson.tool.BankReconciliationInfoBO;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

public class CurrentTest {

    public static void main(String[] args) throws JsonProcessingException, InterruptedException {

        CurrentTest currentTest = new CurrentTest();

        //currentTest.testSingletonSingleThread();
        currentTest.testSingletonMulThread();
        //currentTest.testNewSingleThread();
        //currentTest.testNewMulThread();

    }



    /**
     * 单例-单线程模式 //600-700
     */
    public void testSingletonSingleThread() throws JsonProcessingException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            JacksonUtils.INSTANCE.getSingletonObjectMapper().writeValueAsString(new BankReconciliationInfoBO()
                    .setBankTradeNo(Integer.toString(i))
                    .setBankTransactionAmount(new BigDecimal("10000.00" + i)));
        }
        System.out.println("单例 - 单线程 最终用时:" + (System.currentTimeMillis() - start) + "ms");//30,14,14,平均值:19.33
    }

    /**
     * 单例-多线程模式 //1200-2000
     */
    public void testSingletonMulThread() throws InterruptedException {
        final int count = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    JacksonUtils.INSTANCE.getSingletonObjectMapper().writeValueAsString(new BankReconciliationInfoBO()
                            .setBankTradeNo(Integer.toString(finalI))
                            .setBankTransactionAmount(new BigDecimal("10000.00" + finalI)));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("单例 - 多线程 最终用时:" + (System.currentTimeMillis() - start) + "ms");//79,153,67,平均值:99.66
    }



    /**
     * new对象-单线程模式 //1000-1100
     */
    public void testNewSingleThread() throws JsonProcessingException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            new ObjectMapper().writeValueAsString(new BankReconciliationInfoBO()
                    .setBankTradeNo(Integer.toString(i))
                    .setBankTransactionAmount(new BigDecimal("10000.00" + i)));
        }
        System.out.println("new对象 - 单例 最终用时:" + (System.currentTimeMillis() - start) + "ms");//153,125,135,平均值:137.66
    }

    /**
     * new对象-多线程模式 //1300-2900 很不不稳定 1300
     */
    public void testNewMulThread() throws InterruptedException {
        final int count = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    JacksonUtils.INSTANCE.getSingletonObjectMapper().writeValueAsString(new BankReconciliationInfoBO()
                            .setBankTradeNo(Integer.toString(finalI))
                            .setBankTransactionAmount(new BigDecimal("10000.00" + finalI)));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("new对象 - 多线程 最终用时:" + (System.currentTimeMillis() - start) + "ms");//225,173,161,平均值:186.33
    }
}
