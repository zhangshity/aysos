package com.zcy.time.threadSafe_SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));


    public static void main(String[] args) {

        // 1.静态SimpleDateFormat 线程安全验证(多线程环境 - Date格式化成String,再解析回Date,再次格式化成String2.  出现String和String2不同,false情况(还有异常)
        // 【线程不安全】)
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                try {
//                    String date = sf.format(new Date());
//                    Date dateParse = sf.parse(date);
//                    String dateReformat = sf.format(dateParse);
//                    System.out.println(Thread.currentThread().getName() + ": " + date.equals(dateReformat) + " | " + date + " _ " + dateReformat);
//
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }

        // 2.独立实例SimpleDateFormat 线程安全验证(多线程环境 - Date格式化成String,再解析回Date,再次格式化成String2.  未出现String和String2不同,均为true
        // 【线程安全,系统开销高】)
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                try {
//                    String date = sf.format(new Date());
//                    Date dateParse = sf.parse(date);
//                    String dateReformat = sf.format(dateParse);
//                    System.out.println(Thread.currentThread().getName() + ": " + date.equals(dateReformat) + " | " + date + " _ " + dateReformat);
//
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }


        // 3.synchronized锁SimpleDateFormat 线程安全验证(多线程环境 - Date格式化成String,再解析回Date,再次格式化成String2.  未出现String和String2不同,均为true
        // 【线程安全,系统开销高】)
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                try {
//                    synchronized (sf) {
//                        String date = sf.format(new Date());
//                        Date dateParse = sf.parse(date);
//                        String dateReformat = sf.format(dateParse);
//                        System.out.println(Thread.currentThread().getName() + ": " + date.equals(dateReformat) + " | " + date + " _ " + dateReformat);
//                    }
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }


        // 4.ThreadLocal线程副本SimpleDateFormat 线程安全验证(多线程环境 - Date格式化成String,再解析回Date,再次格式化成String2.  未出现String和String2不同,均为true
        // 【线程安全】)
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SimpleDateFormat sf = threadLocal.get();
            try {
                    String date = sf.format(new Date());
                    Date dateParse = sf.parse(date);
                    String dateReformat = sf.format(dateParse);
                    System.out.println(Thread.currentThread().getName() + ": " + date.equals(dateReformat) + " | " + date + " _ " + dateReformat);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }



}
