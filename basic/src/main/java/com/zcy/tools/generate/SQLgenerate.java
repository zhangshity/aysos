package com.zcy.tools.generate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SQLgenerate {

    public static void main(String[] args) throws ParseException {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date beginDateTime = simpleDateFormat.parse("2020-01-01 00:00:00");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDateTime);
//        calendar.add(Calendar.DAY_OF_MONTH, 7);
//        Date dateAdd = calendar.getTime();
//        String dateTimeString = simpleDateFormat.format(dateAdd);


        //String sql = "UPDATE ccps_traderecord SET tr_bankreturncode = '80000', tr_bankinfo = 'Transaction Approved' WHERE tr_status = 1 AND tr_datetime >= to_date('" + dateTimeString + "','yyyy-mm-dd hh24:mi:ss') AND tr_datetime < to_date('" + dateTimeString + "','yyyy-mm-dd hh24:mi:ss');\n";

        String sql = null;
        for (int i = 0; i < 37; i++) {
            Date dateAdd = calendar.getTime();
            String dateTimeString = simpleDateFormat.format(dateAdd);
            sql = "UPDATE ccps_traderecord SET tr_bankreturncode = '80000', tr_bankinfo = 'Transaction Approved' WHERE tr_status = 1 AND tr_datetime >= to_date('"
                    + dateTimeString
                    + "','yyyy-mm-dd hh24:mi:ss') AND tr_datetime < to_date('";

            calendar.add(Calendar.DAY_OF_MONTH, 7);
            Date dateAdd2 = calendar.getTime();
            String dateTimeString2 = simpleDateFormat.format(dateAdd2);
            sql = sql + dateTimeString2 + "','yyyy-mm-dd hh24:mi:ss');\n";


            System.out.println(sql);
        }






        //System.out.println(dateTimeString);












    }
}
