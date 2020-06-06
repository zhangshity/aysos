package com.zcy.string_test;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 10:57 2020/6/1
 * @ Modified: By:
 */
public class Split {
    public static void main(String[] args) {
        String dateParam = "2020-05-26";
        System.out.println(System.currentTimeMillis());
        String[] date = dateParam.split("-");
        String year = date[0];
        String month = date[1];
        String day = date[2];
        System.out.println(year + " " + month + " " + day);
        System.out.println(System.currentTimeMillis());


        //================================2020-06-06 20:42:?? Sat.
        System.out.println("//================================2020-06-06 20:42:?? Sat.");
        String beginDateTime = "2020-05-26 13:25:35";
        String endDateTime = "2020-05-26 20:24:12";

        System.out.println(beginDateTime.split(" ")[0]);
        System.out.println(endDateTime.split(" ")[0]);
        System.out.println(beginDateTime.split(" ")[0].equals(endDateTime.split(" ")[0]));
    }
}
