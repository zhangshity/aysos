package com.zcy.date_time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCompare {
    public static void main(String[] args) throws ParseException {
        String dateStr1 = "2020-05-26";
        String dateStr2 = "2019-11-28";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = simpleDateFormat.parse(dateStr1);
        Date date2 = simpleDateFormat.parse(dateStr2);


        System.out.println(date1); //Tue May 26 00:00:00 CST 2020
        System.out.println(date2); //Thu Nov 28 00:00:00 CST 2019
        System.out.println(date1.getTime()); //1590422400000
        System.out.println(date2.getTime()); //1574870400000

        System.out.println(dateStr1.compareTo(dateStr2)); //1
        System.out.println(date1.compareTo(date2)); //1
        System.out.println(date1.getTime() <= date2.getTime()); //false
        System.out.println(date1.before(date2)); //false
        System.out.println(date1.after(date2)); //true
    }
}
