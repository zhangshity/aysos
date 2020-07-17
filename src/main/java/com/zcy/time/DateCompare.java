package com.zcy.time;

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
        Long dateLong1 = date1.getTime();
        Long dateLong2 = date2.getTime();

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(dateLong1);
        System.out.println(dateLong2);

        System.out.println(dateStr1.compareTo(dateStr2));
        System.out.println(date1.compareTo(date2));
        System.out.println(dateLong1 <= dateLong2);
        System.out.println(date1.before(date2));
        System.out.println(date1.after(date2));
    }
}
