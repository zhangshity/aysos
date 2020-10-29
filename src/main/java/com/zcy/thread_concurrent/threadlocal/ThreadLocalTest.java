package com.zcy.thread_concurrent.threadlocal;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: ThreadLocalTest</p >
 * <p>Description: </p >
 *
 * @author Allen
 * @version V1.0
 * @date 2020年07月23号 12点59分43秒
 */
public class ThreadLocalTest {

    public static int add(int num) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return num + 10;
    }


    public static void main(String[] args) {

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        
        for (int i = 0; i < 10; i++) {
            int temp = i;
            new Thread(() -> System.out.println(Thread.currentThread().getName() + " " + temp + " " + ThreadLocalTest.add(temp))).start();
        }


//        new Thread(new FutureTask<Object>(new Callable<Object>() {
//            public Object call() throws Exception {
//                threadLocal.set(i);
//                System.out.println("i " + threadLocal.get());
//                return i;
//            }
//        })).start();
//
//        new Thread(new FutureTask<Object>(new Callable<Object>() {
//            public Object call() throws Exception {
//                threadLocal.set(i);
//                System.out.println("i " + threadLocal.get());
//                return i;
//            }
//        })).start();
//
//        new Thread(new FutureTask<Object>(new Callable<Object>() {
//            public Object call() throws Exception {
//                threadLocal.set(i);
//                System.out.println("i " + threadLocal.get());
//                return i;
//            }
//        })).start();


    }
}