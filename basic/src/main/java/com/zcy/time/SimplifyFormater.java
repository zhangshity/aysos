package com.zcy.time;

import org.apache.commons.lang3.StringUtils;

import static java.time.LocalDate.now;
import static java.time.LocalDate.parse;
import static java.time.format.DateTimeFormatter.ofPattern;

public class SimplifyFormater {
    public static void main(String[] args) {

        String date = "20201025";

        String s = StringUtils.isBlank(date) ? ofPattern("yyyy/MM/dd").format(now())
                : ofPattern("yyyy/MM/dd").format(parse(date, ofPattern("yyyyMMdd")));


        System.out.println(s);
    }
}
