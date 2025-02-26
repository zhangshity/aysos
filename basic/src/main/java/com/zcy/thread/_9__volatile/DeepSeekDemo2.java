package com.zcy.thread._9__volatile;

public class DeepSeekDemo2 {
    // 去掉 volatile 会导致线程 B 死循环
//     private static boolean flag = true;
    private static volatile boolean flag = true;


    public static void main(String[] args) {
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

}
