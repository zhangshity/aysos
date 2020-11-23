package com.zcy.basic_data_type;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CalculateTest {
    public static void main(String[] args) {

        double amount = 3775.4868;
        int dot = 0;

        double result;

        System.out.println(new DecimalFormat("#").format(result = amount * Math.pow(10, dot)));
        //System.out.println(result);


        BigDecimal bigDecimal = new BigDecimal("3775.4868");
        System.out.println(bigDecimal.multiply(new BigDecimal("1")).setScale(0,BigDecimal.ROUND_HALF_UP));



    }
}
