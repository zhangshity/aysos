package com.zcy.thread_concurrent._2__readwrite_lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    // 共享数据
    private static int sharedData = 0;
    // 创建读写锁
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    // 读锁
    private static final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    // 写锁
    private static final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    public static void main(String[] args) {
        // 读线程
        Thread readThread1 = new Thread(() -> {
            readLock.lock();
            try {
                System.out.println("读线程1读取到数据: " + sharedData);
            } finally {
                readLock.unlock();
            }
        });

        Thread readThread2 = new Thread(() -> {
            readLock.lock();
            try {
                System.out.println("读线程2读取到数据: " + sharedData);
            } finally {
                readLock.unlock();
            }
        });

        // 写线程
        Thread writeThread = new Thread(() -> {
            writeLock.lock();
            try {
                sharedData = 10;
                System.out.println("写线程修改数据为: " + sharedData);
            } finally {
                writeLock.unlock();
            }
        });

        readThread1.start();
        readThread2.start();
        writeThread.start();
    }
}