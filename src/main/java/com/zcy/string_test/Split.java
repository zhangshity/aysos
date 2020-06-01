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
    }
}
