package com.zcy.string_test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class MatchesTest {
    public static void main(String[] args) throws ParseException {

        String s = "1asc";
        String s1 = "1desc";
        String s2 = "123456desc";
        String s3 = "";
        String s4 = "asda";
        String s5 = "{!~$!@$%zfzf";
        String snull = null;

        test(s1);
    }

    private static void test(String str) throws ParseException {
        System.out.println("endsWith(\"asc\") " + str.endsWith("asc"));
        System.out.println("endsWith(\"desc\") " + str.endsWith("desc"));
        System.out.println("endsWith(\"asc\") ||endsWith(\"desc\") " + (str.endsWith("asc") || str.endsWith("desc")));


        System.out.println(str.matches("[0-9].*"));
        System.out.println(str.matches("[0-9][a-z].*"));
        System.out.println((str.matches("[0-9][a-z][a-z][a-z]") || str.matches("[0-9][a-z][a-z][a-z][a-z]")));



        //=================================== Supp. 2021-05-25 ===================================

        System.out.println("----------matches日期1： " + "2021-05-25".matches("dddd-dd-dd"));
        System.out.println("----------matches日期2： " + "2021-05-25".matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}"));
        System.out.println("----------matches日期2： " + "2021-05-5".matches("\\d{4}[-]\\d{1,2}[-]\\d{1,2}"));


        System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2021-5-05"));


//        Date date = Optional.ofNullable("2021-05-25")
//                .filter(acceptorDate -> acceptorDate.matches("dddd-dd-dd"))
//                .map(x -> {
//                    try {
//                        return new SimpleDateFormat("yyyy-MM-dd").parse(x);
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//                })
//                .orElse(null);
//
//        System.out.println(date);

    }
}
