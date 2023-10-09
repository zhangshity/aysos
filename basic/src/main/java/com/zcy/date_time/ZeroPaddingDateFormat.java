package com.zcy.date_time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.format.SignStyle;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;

/**
 * 兼容日期中 month 和 day 为单数时的情况。能兼容解析
 */
public class ZeroPaddingDateFormat {
    public static void main(String[] args) {

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendValue(YEAR, 4)
                .appendLiteral('/')
                .appendValue(MONTH_OF_YEAR, 1, 2, SignStyle.NEVER)
                .appendLiteral('/')
                .appendValue(DAY_OF_MONTH, 1, 2, SignStyle.NEVER)
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT);


        LocalDate date1 = LocalDate.parse("2021/4/3", formatter);
        System.out.println(date1);

        LocalDate date2 = LocalDate.parse("2021/04/03", formatter);
        System.out.println(date2);
    }
}
