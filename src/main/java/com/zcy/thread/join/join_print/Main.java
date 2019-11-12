package com.zcy.thread.join.join_print;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread tFormer = new Thread(new Former(), "Former Thread");
        Thread tLater = new Thread(new Later(), "Later Thread");
        tFormer.start();
        tFormer.join(); //Former线程完成后,Later线程才继续
        tLater.start();
    }
}
