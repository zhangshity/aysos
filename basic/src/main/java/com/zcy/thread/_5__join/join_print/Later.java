package com.zcy.thread._5__join.join_print;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Later implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i + " " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

        }
    }
}
