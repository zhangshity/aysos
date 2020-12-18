package com.zcy.time.fucku;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class FuckingTest {
    public static void main(String[] args) {

        //System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));


        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(dateTimeFormatter.format(localDateTime));


        Calendar calendar = Calendar.getInstance();
        new Date().toInstant();
        LocalDateTime localDateTime2 = Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime2);


    }
}
