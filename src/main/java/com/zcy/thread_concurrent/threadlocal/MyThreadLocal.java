package com.zcy.thread_concurrent.threadlocal;

import com.zcy.spring.transaction.pojo.Student;


public class MyThreadLocal {

    private static final ThreadLocal<Student> threadLocal = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return new Student("Allen", 18);
        }
    };

    public static Student get() {
        return threadLocal.get();
    }

    public static void set(Student student) {
        threadLocal.set(student);
    }






    // Main
    public static void main(String[] args) throws InterruptedException {
        // 打印ThreadLocal初始值
        System.out.println(MyThreadLocal.get());

        // 主线程睡眠1秒
        Thread.sleep(1000);




        // 创建线程,分别设置
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                MyThreadLocal.set(new Student("Allen_" + Thread.currentThread().getName(), 22));
                System.out.println(Thread.currentThread().getName() + "_" + MyThreadLocal.get());
            }).start();
        }


    }
}
