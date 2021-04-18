package com.zcy.thread_concurrent._1__lock.conditional;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    public static void main(String[] args) {

        ConditionTest test = new ConditionTest();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{ test.talk(); }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(()->{test.fuck();}, String.valueOf(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(()->{test.nap();}, String.valueOf(i)).start();
        }
    }



    // 锁
    Lock lock = new ReentrantLock();

    // 条件对象
    final Condition talk = lock.newCondition();
    final Condition fuck = lock.newCondition();
    final Condition nap = lock.newCondition();

    public void talk() {
        lock.lock();
        try {
            System.out.println("Lets talk!");
            fuck.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void fuck() {
        lock.lock();
        try {
            fuck.await();
            System.out.println("Lets fuck!");
            nap.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void nap() {
        lock.lock();
        try {
            nap.await();
            System.out.println("Lets nap!");
            talk.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
