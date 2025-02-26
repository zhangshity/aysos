package com.zcy.thread._14_Condition;

public class SyncWaitTest {
    private static int num = 1;
    private static final Object lock = new Object();
    private static boolean isThreadATurn = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (num <= 100) {
                synchronized (lock) {
                    if (!isThreadATurn) {
//                        try { lock.wait(); } catch (Exception e) {}
                    } else {
                        System.out.println("Thread-A: " + num++);
                        isThreadATurn = false;
//                        lock.notify();
                    }
                }
            }
        }, "Thread-A").start();

        new Thread(() -> {
            while (num <= 100) {
                synchronized (lock) {
                    if (isThreadATurn) {
//                        try { lock.wait(); } catch (Exception e) {}
                    } else {
                        System.out.println("Thread-B: " + num++);
                        isThreadATurn = true;
//                        lock.notify();
                    }
                }
            }
        }, "Thread-B").start();
    }
}
