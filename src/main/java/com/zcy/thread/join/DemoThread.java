package com.zcy.thread.join;

public class DemoThread implements Runnable {

    private String value;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "DemoThread have data value";
    }


    public static void main(String[] args) throws InterruptedException {
        DemoThread demoThread = new DemoThread();
        Thread t = new Thread(demoThread);
        t.start();

//        while (demoThread.value == null) {
//            Thread.sleep(100);
//        }
        t.join(); //与循环等待一样的效果

        System.out.println("value: " + demoThread.value);
    }
}
