package com.zcy.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//Daddy Yang - 2020-06-03
public class CalendarTest {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.MAY, 26, 0, 0, 0);
        Date date = calendar.getTime();
        System.out.println("calendar.getTime() ->\n" + date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String resultDate = simpleDateFormat.format(date);
        System.out.println("Date date = simpleDateFormat.format(date) ->\n"+resultDate);


        //==========================================
        String d = "2020-05-26 13:30:20";
        String d2 = "20200526 13:30:20";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = sf.parse(d);
            Date date2 = sf.parse(d2);
            System.out.println("simpleDateFormat.parse(date) ->\n"+date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
