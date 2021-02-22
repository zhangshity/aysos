package com.zcy.time;

import java.time.ZoneId;

public class TimeZone {
    public static void main(String[] args) {


        java.util.TimeZone timeZone = java.util.TimeZone.getDefault();
        System.out.println(timeZone.getID());

        System.out.println(ZoneId.systemDefault().getId());

    }
}
