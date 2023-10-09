package com.zcy.date_time.timestemp;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

public class TimestampTest {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println("毫秒级时间戳:\n" + l);

        Instant now = Instant.now();
        long epochSecond = now.getEpochSecond();
        int nano = now.getNano();
        long epochMilli = now.toEpochMilli();
        System.out.println("epochSecond:\n" + epochSecond);
        System.out.println("nano:\n" + nano);
        System.out.println("epochMilli:\n" + epochMilli);


        Date date = new Date();
        long time = date.getTime();
        System.out.println("Date.getTime():\n" + time);

        Clock clock = Clock.systemUTC();
        long millis = clock.millis();
        System.out.println("Clock.millis():\n" + millis);
    }
}
