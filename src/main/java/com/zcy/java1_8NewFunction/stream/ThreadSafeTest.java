package com.zcy.java1_8NewFunction.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> syncList = Collections.synchronizedList(new ArrayList<>()); //非线程安全的
        List<Integer> cpOnWrList = new CopyOnWriteArrayList<>(); //CopyOnWrite的写操作性能差,复制集合浪费内存,分分中内存爆炸

        for (int i = 0; i < 50000; i++) {
            list1.add(i);
        }

        // 线程安全问题 (ForkJoinPool多线程操作一个线程不安全的ArrayList)
        list1.parallelStream().forEach(j -> {
            list2.add(j);        // 线程不安全,出现数组下标越界或统计不准确问题
            syncList.add(j);     // 线程安全,Synchronized加锁的List
            cpOnWrList.add(j);   // 线程安全,读写分离,写复制元素加锁的List(写并发多,内存会爆炸)
        });

        System.out.println("  >>> list1 预计长度 :: {}" + list1.size());
        System.out.println("  >>> list2 实际长度 :: {}" + list2.size());
        System.out.println("  >>> syncList 实际长度 :: {}" + syncList.size());
        System.out.println("  >>> cpOnWrList 实际长度 :: {}" + cpOnWrList.size());
    }
}
