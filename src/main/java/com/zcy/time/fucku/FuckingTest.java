package com.zcy.time.fucku;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class FuckingTest {
    public static void main(String[] args) {

        System.out.println("================== 基本时间获取 ==================");
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);

        System.out.println("================== 日期时间相互转化 ==================");
        LocalDate toLocalDate = localDateTime.toLocalDate();
        LocalTime toLocalTime = localDateTime.toLocalTime();
        LocalDateTime ofLocalDateTime = LocalDateTime.of(toLocalDate, toLocalTime);
        LocalDateTime diyDatePart = LocalDateTime.now().with(LocalDate.MIN);
        LocalDateTime diyTimePart = LocalDateTime.now().with(LocalTime.MIDNIGHT);

        System.out.println(toLocalDate);
        System.out.println(toLocalTime);
        System.out.println(ofLocalDateTime);
        System.out.println(diyDatePart);
        System.out.println(diyTimePart);

        System.out.println("================== 格式化时间 ==================");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(localDateTime));
        System.out.println(dateTimeFormatter1.format(localDateTime));


        System.out.println("================== 时间点获取和转化 ==================");
        Instant instant = Instant.now();
        LocalDateTime instantAtZone = Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime();

        System.out.println(instant);
        System.out.println(instantAtZone);



        System.out.println("================== 新旧时间类的转化 ==================");
        Instant fromDate = new Date().toInstant();
        Instant fromCalendar = Calendar.getInstance().toInstant();
        Date fromInstant = Date.from(Instant.now());

        System.out.println(fromDate);
        System.out.println(fromCalendar);
        System.out.println(fromInstant);

        System.out.println("================== 时间计算 ==================");
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 1, 0, 0, 0);
        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 10, 15, 18, 30, 24);
        Duration duration = Duration.between(localDateTime1, localDateTime2);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMillis() / 1000);
        System.out.println(duration.getSeconds());

        LocalDate localDate1 = LocalDate.of(2020, 10, 1);
        LocalDate localDate2 = LocalDate.of(2020, 11, 30);
        Period period = Period.between(localDate1, localDate2);
        System.out.println(period.toTotalMonths());
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
        System.out.println(period.getYears());
    }
}
