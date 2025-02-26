package com.zcy.thread._14_Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两线程交替打印1-100  Condition
 */
public class Test {
    private static int num = 1;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static boolean isThreadATurn = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (num <= 100) {
                lock.lock();
                try {
                    if (!isThreadATurn) {
                        conditionA.await();
                    }
                    System.out.println("Thread-A: " + num++);
                    isThreadATurn = false;
                    conditionB.signal();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
            }
        }, "Thread-A").start();

        new Thread(() -> {
            while (num <= 100) {
                lock.lock();
                try {
                    if (isThreadATurn) {
                        conditionB.await();
                    }
                    System.out.println("Thread-B: " + num++);
                    isThreadATurn = true;
                    conditionA.signal();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
            }
        }, "Thread-B").start();
    }
}
