package com.zcy.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//Daddy Yang - 2020-06-03
public class CalendarTest {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.MAY, 26, 0, 0, 0);
        Date date = calendar.getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String resultDate = simpleDateFormat.format(date);
        System.out.println(resultDate);
    }
}
