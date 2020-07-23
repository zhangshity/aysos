package com.zcy.thread_concurrent.threadlocal;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * <p>Title: ThreadLocalTest</p >
 * <p>Description: </p >
 *
 * @author Allen
 * @version V1.0
 * @date 2020年07月23号 12点59分43秒
 */
public class ThreadLocalTest {

    private int i=0;

    Thread t1 = new Thread(new FutureTask<Object>(new Callable<Object>() {
        public Object call() throws Exception {
            ThreadLocal threadLocal = new ThreadLocal();
            threadLocal.set(i);
            i = 1 ;
            System.out.println("i " + threadLocal.get());
            return i;
        }
    }));

    Thread t2 = new Thread(new FutureTask<Object>(new Callable<Object>() {
        public Object call() throws Exception {
            ThreadLocal threadLocal = new ThreadLocal();
            threadLocal.set(i);
            i = 5;
            System.out.println("i " + threadLocal.get());
            return i;
        }
    }));

    Thread t3 = new Thread(new FutureTask<Object>(new Callable<Object>() {
        public Object call() throws Exception {
            ThreadLocal threadLocal = new ThreadLocal();
            threadLocal.set(i);
            i = 10;
            System.out.println("i " + threadLocal.get());
            return i;
        }
    }));

    public static void main(String[] args) {

        ThreadLocalTest demo = new ThreadLocalTest();


        demo.t1.start();
        demo.t2.start();
        demo.t3.start();





    }
}