package com.zcy.thread._9__volatile;

public class DeepSeekDemo {
    // 去掉 volatile 会导致线程 B 死循环
    // private boolean flag = true;
    private volatile boolean flag = true;


    public void start() {
        new Thread(() -> {
            while (flag) { /* 循环 */    //不能print,内置synchronized会强制刷新主存到线程工作内存
            }
            System.out.println("Thread B: flag is false");
        }).start();

        new Thread(() -> {
            try { Thread.sleep(1000); } catch (Exception e) {}
            flag = false; // 修改 flag
            System.out.println("Thread A: set flag to false");
        }).start();
    }

    // main
    public static void main(String[] args) {
        new DeepSeekDemo().start();
    }
}
