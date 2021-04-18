package com.zcy.thread._1__thread.thread_1;

public class Main {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start(); //进入就绪状态(Ready)等待调度,调度分配到处理机就会运行run()方法  - 运行线程为: Thread-0
//        myThread.run(); //直接进入运行状态(Running)                                    - 运行线程为: main
    }
}
