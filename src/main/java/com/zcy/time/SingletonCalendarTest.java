package com.zcy.time;

import java.util.Calendar;

public class SingletonCalendarTest {
    public static void main(String[] args) throws InterruptedException {
        //Calendar为单例模式，测试其单例存储的影响


//        Calendar c2 = Calendar.getInstance();
//        System.out.println(c2.getTime());
//        System.out.println("今天几时 " + c2.get(Calendar.HOUR_OF_DAY));


        Calendar c1 = Calendar.getInstance();
        System.out.println(c1.getTime());
        c1.set(2020, Calendar.JUNE, 10, 9,  30,0);
        System.out.println(c1.getTime());
        System.out.println("今天几时 " + c1.get(Calendar.HOUR_OF_DAY));

//        c1.clear();
        System.out.println("====================================");
        Thread.sleep(2000);

        Calendar c2 = Calendar.getInstance();
        System.out.println(c2.getTime());
        System.out.println("今天几时 " + c2.get(Calendar.HOUR_OF_DAY));


        //结论 - 每次getInstance()值都被初始化了,不用再次清零或考虑Clear()方法，作用不同
    }
}
