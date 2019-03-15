package com.zcy.date_contol.month_plus_sub;

/**
 * @ Author: chunyang.zhang
 * @ Description: 定义年月(月份为一月),求上个年月
 * @ Date: Created in 10:28 2019-03-15
 * @ Modified: By:
 */
public class LastMonthofJanuary {

    public static void main(String[] args) {

        String yearMonth = "201901";
        String lastYearMonth = null;
        //测试substring(index1,index2)
        //System.out.println(yearMonth.substring(0,4)); // 前闭后开

        if (yearMonth.substring(4, 6).equals("01")) {
            lastYearMonth = String.valueOf((Integer.parseInt(yearMonth.substring(0, 4)) - 1) * 100 + 12);
        } else {
            lastYearMonth = String.valueOf(Integer.parseInt(yearMonth) - 1);
        }

        System.out.println(yearMonth+"'s last year and month is : >>> " + lastYearMonth);


    }
}
