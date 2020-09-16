package com.zcy.time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Java8TimePackageTest {
    public static void main(String[] args) {

        //1.旧项目获取UTC时间
        // 取得本地时间：
        Calendar cal = Calendar.getInstance();
        // 取得时间偏移量：
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        // 取得夏令时差：
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        // 从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        String xDate =  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(cal.getTime());
        System.out.println(xDate);



        // 2.java8新增
        System.out.println("==========================java8==================================");
        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println(">>>>> OffsetDateTime");
        OffsetDateTime offsetDateTime = OffsetDateTime.now(ZoneOffset.UTC);
        System.out.println(offsetDateTime);


        System.out.println("==================joda=============================");
        // 3.joda
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        System.out.println(dateTime);
        String dateTimeAsString = dateTime.toString();
        System.out.println(dateTimeAsString);
        System.out.println(">>>>> toDateTime");



        System.out.println("====================joda娱乐测试====================================");
        DateTime dateTime1 = new DateTime();
        DateTime dateTime2 = new DateTime(new Date());
        DateTime dateTime3 = new DateTime(2020, 9, 11, 14, 52, 18);
        System.out.println(dateTime1);
        System.out.println(dateTime2);
        System.out.println(dateTime3);
    }
}
