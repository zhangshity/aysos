package com.zcy.tools.decimal_format;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BigDecimal2String {

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal(1233.128800); //1233.12879999999995561665855348110198974609375 精度丢失

        BigDecimal bigDecimal2 = new BigDecimal("1233.128800"); //1233.128800  精度完全保留 String -> BigDecimal : new BigDecimal(str)

        BigDecimal bigDecimal3 = BigDecimal.valueOf(1233.128800); //1233.1288 小数点最后00丢失(00其实无意义)

        BigDecimal bigDecimal4 = new BigDecimal(Double.valueOf(1233.128800).toString()); //1233.1288 小数点最后00丢失 Double.valueOf()丢失 - java默认double多此一举

        BigDecimal bigDecimal5 = new BigDecimal(String.valueOf(1233.128800)); //1233.1288 小数点最后00丢失(00其实无意义)


        System.out.println(bigDecimal);
        System.out.println(bigDecimal2);
        System.out.println(bigDecimal3);
        System.out.println(bigDecimal4);
        System.out.println(bigDecimal5);
        System.out.println(bigDecimal2.doubleValue());

//        System.out.println(bigDecimal.toString());
//        System.out.println(bigDecimal2.toString());


        double d = 12.30;
        System.out.println(d);




        System.out.println("=================================================");
        BigDecimal b1 = BigDecimal.valueOf(100.0);
        BigDecimal b2 = BigDecimal.valueOf(0.01);
        System.out.println(b1.equals(b2));
        System.out.println(b1.compareTo(b2) == 0);


        System.out.println(b1.multiply(b2));







        //======================= BigDecimal 除法===================================================
        System.out.println("======================= BigDecimal 除法===================================================");
        BigDecimal t1 = new BigDecimal("1");
        BigDecimal result = t1.divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_UNNECESSARY);
        System.out.println(result);







    }
}
