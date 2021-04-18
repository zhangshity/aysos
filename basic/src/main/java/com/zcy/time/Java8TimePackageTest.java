package com.zcy.time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

public class Java8TimePackageTest {
    public static void main(String[] args) {

        //1.旧项目获取UTC时间
        // 取得本地时间：
        Calendar cal = Calendar.getInstance();
        // 取得时间偏移量：
        int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
        // 取得夏令时差：
        int dstOffset = cal.get(Calendar.DST_OFFSET);
        // 从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
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
        System.out.println(dateTime1); //2020-12-18T15:54:08.686+08:00
        System.out.println(dateTime2); //2020-12-18T15:54:08.705+08:00
        System.out.println(dateTime3); //2020-09-11T14:52:18.000+08:00

        LocalDateTime localDateTime = new LocalDateTime();
        System.out.println(localDateTime); //2020-12-18T15:54:08.725
    }
}
