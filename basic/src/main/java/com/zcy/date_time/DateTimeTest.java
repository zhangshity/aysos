package com.zcy.date_time;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeTest {
    public static void main(String[] args) throws ParseException {

        String dateTime = "2020-05-26 13:25:35";

        //拆分String日期
        String[] dateTimeSplit = dateTime.split(" ");
        String dateString = dateTimeSplit[0];
        //拼接 00:00:00 时间
        String newDateTime = dateString + " 00:00:00";
        System.out.println("|" + newDateTime + "|");


        System.out.println(dateTime.length());

        String testDate = "2020-05/26 13:25:35";
        System.out.println(isDateTimeFormat(testDate));
        if (isDateTimeFormat(testDate)) {
            System.out.println("1234Successful");
        }

    }

    private static boolean isDateTimeFormat(String date) {
        //标志默认false
        boolean flag = false;
        if (date.length() == 19) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                simpleDateFormat.parse(date);
                flag = true;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
