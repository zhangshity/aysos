package com.zcy.time;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class GMTorUTC {
    public static void main(String[] args) {


        Date date = new Date();

        System.out.println("================ GMT ================");
        SimpleDateFormat simpleDateFormat_ = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        simpleDateFormat_.setTimeZone(TimeZone.getTimeZone("GMT"));
        String s_ = simpleDateFormat_.format(date);
        System.out.println(s_);


        System.out.println("================ GMT指定 -12时区 ================");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-12:00"));
        String s_12 = simpleDateFormat.format(date);
        System.out.println(s_12);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-11:00"));
        String s_11 = simpleDateFormat.format(date);
        System.out.println(s_11);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-10:00"));
        String s_10 = simpleDateFormat.format(date);
        System.out.println(s_10);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-9:00"));
        String s_9 = simpleDateFormat.format(date);
        System.out.println(s_9);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-8:00"));
        String s_8 = simpleDateFormat.format(date);
        System.out.println(s_8);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-7:00"));
        String s_7 = simpleDateFormat.format(date);
        System.out.println(s_7);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-6:00"));
        String s_6 = simpleDateFormat.format(date);
        System.out.println(s_6);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
        String s_5 = simpleDateFormat.format(date);
        System.out.println(s_5);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-4:00"));
        String s_4 = simpleDateFormat.format(date);
        System.out.println(s_4);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-3:00"));
        String s_3 = simpleDateFormat.format(date);
        System.out.println(s_3);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-2:00"));
        String s_2 = simpleDateFormat.format(date);
        System.out.println(s_2);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-1:00"));
        String s_1 = simpleDateFormat.format(date);
        System.out.println(s_1);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-0:00"));
        String s_0 = simpleDateFormat.format(date);
        System.out.println(s_0);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String s0 = simpleDateFormat.format(date);
        System.out.println(s0);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+1:00"));
        String s1 = simpleDateFormat.format(date);
        System.out.println(s1);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+2:00"));
        String s2 = simpleDateFormat.format(date);
        System.out.println(s2);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3:00"));
        String s3 = simpleDateFormat.format(date);
        System.out.println(s3);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+4:00"));
        String s4 = simpleDateFormat.format(date);
        System.out.println(s4);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:00"));
        String s5 = simpleDateFormat.format(date);
        System.out.println(s5);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+6:00"));
        String s6 = simpleDateFormat.format(date);
        System.out.println(s6);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
        String s7 = simpleDateFormat.format(date);
        System.out.println(s7);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String s8 = simpleDateFormat.format(date);
        System.out.println("东8"+s8);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+9:00"));
        String s9 = simpleDateFormat.format(date);
        System.out.println(s9);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+10:00"));
        String s10 = simpleDateFormat.format(date);
        System.out.println(s10);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+11:00"));
        String s11 = simpleDateFormat.format(date);
        System.out.println(s11);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+11:30"));
        String s11p5 = simpleDateFormat.format(date);
        System.out.println("半小时时区" +s11p5);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+12:00"));
        String s12 = simpleDateFormat.format(date);
        System.out.println(s12);



        System.out.println("================ UTC ================");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        String sUTC = simpleDateFormat2.format(date);
        System.out.println(sUTC);


        System.out.println("================ UTC指定 -12时区 ================");
        SimpleDateFormat simpleDateFormat22 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        simpleDateFormat22.setTimeZone(TimeZone.getTimeZone("UTC-12:00"));
        String s22 = simpleDateFormat22.format(date);
        System.out.println(s22);


        System.out.println("================ 系统默认时区 ================");
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        simpleDateFormat3.setTimeZone(TimeZone.getDefault());
        String sDefault = simpleDateFormat3.format(date);
        System.out.println(sDefault);


        System.out.println("================ !!!!!!!!!!! ================");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println(dateTimeFormatter.format(timestamp.toInstant().atZone(ZoneId.of("GMT-00:00"))));
        System.out.println(dateTimeFormatter.format(timestamp.toInstant().atZone(ZoneId.of("GMT+08:00"))));
        System.out.println(dateTimeFormatter.format(timestamp.toInstant().atZone(ZoneId.of("UTC+10:00"))));


    }
}
