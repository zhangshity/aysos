package com.zcy.tools.decimal_format;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BigDecimal2String {

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal(1233.128800);

        BigDecimal bigDecimal2 = new BigDecimal("1233.128800");

        BigDecimal bigDecimal3 = BigDecimal.valueOf(1233.128800);

        BigDecimal bigDecimal4 = new BigDecimal(Double.valueOf(1233.128800).toString());


        System.out.println(bigDecimal);
        System.out.println(bigDecimal2);
        System.out.println(bigDecimal3);
        System.out.println(bigDecimal4);

//        System.out.println(bigDecimal.toString());
//        System.out.println(bigDecimal2.toString());

        System.out.println("=================================================");
        BigDecimal b1 = BigDecimal.valueOf(100.0);
        BigDecimal b2 = BigDecimal.valueOf(0.01);
        System.out.println(b1.equals(b2));
        System.out.println(b1.compareTo(b2) == 0);


        System.out.println(b1.multiply(b2));
    }
}
