package com.zcy.thread._5__join.join_print;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Former implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            if (i >= 5) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " " + i + " " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }
    }

}
