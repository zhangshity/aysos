package com.zcy.date_time;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class InstantTest {
    public static void main(String[] args) {

        LocalDateTime startTime = LocalDateTime.of(LocalDate.now().minusDays(1L), LocalTime.MIDNIGHT);
        LocalDateTime endTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
        Timestamp startTimestamp = Timestamp.from(startTime.toInstant(ZoneOffset.UTC));
        Timestamp endTimestamp = Timestamp.from(endTime.toInstant(ZoneOffset.UTC));


        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(startTimestamp);
        System.out.println(endTimestamp);
    }
}
