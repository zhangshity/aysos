package com.zcy.tools.decimal_format;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BigDecimal2String {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

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







        //=================================== 小数位 =========================================================
        System.out.println("=================================== 小数位 =========================================================");
        BigDecimal bigDecimalScale = new BigDecimal("156.2587");
        System.out.println(" new BigDecimal(\"156.2587\")值为: " + bigDecimalScale);
        System.out.println(" new BigDecimal(\"156.2587\") 小数位设置为5 值为: " + bigDecimalScale.setScale(5));
        System.out.println(" new BigDecimal(\"156.2587\") 小数位设置为6 值为: " + bigDecimalScale.setScale(6));

        System.out.println("缩小小数位: - " + "需要四舍五入设置, 否则报Rounding necessary异常");
        System.out.println(" new BigDecimal(\"156.2587\") 小数位设置为3 值为: " + bigDecimalScale.setScale(3,BigDecimal.ROUND_HALF_UP));












        //================= ###### ====== 原理！！！！ ===================================================
        System.out.println("======================= 原理！！！！ ===================================================");
        BigDecimal bigDecimal1 = new BigDecimal("123.56");
        System.out.println("打印new BigDecimal(123.56): " + bigDecimal1);
        System.out.println("打印new BigDecimal(123.56): 小数位scale: " + bigDecimal1.scale());
        System.out.println("打印new BigDecimal(123.56): 无小数部分长度unscale: " + (bigDecimal1.precision() - bigDecimal1.scale()) );
        System.out.println("打印new BigDecimal(123.56): 精度precision: " + bigDecimal1.precision());

        // 反射获取实际存储字段
        Class<?> clazz = Class.forName("java.math.BigDecimal");

        Field intVal = clazz.getDeclaredField("intVal");
        intVal.setAccessible(true);
        BigInteger intValField = (BigInteger) intVal.get(bigDecimal1);
        System.out.println("打印new BigDecimal(123.56): BigIneger值intVal: " + intValField);

        Field intCompact = clazz.getDeclaredField("intCompact");
        intCompact.setAccessible(true);
        long intCompactField = (long) intCompact.get(bigDecimal1);
        System.out.println("打印new BigDecimal(123.56): 消除小数紧凑整数数值intCompact: " + intCompactField);





        //======================== null 测试 =======================================================================
        System.out.println("======================== null 测试 =======================================================================");
//        String s = null;
//        BigDecimal bigDecimal6 = new BigDecimal(s); //NullPointerException
//        System.out.println(bigDecimal6);



        //=========================== toString() 测试 ==============================================================
        System.out.println("=========================== toString() 测试 ==============================================================");
        BigDecimal bigDecimal7 = new BigDecimal("28.00");
        System.out.println(bigDecimal7.toString()); //28.00
        BigDecimal bigDecimal8 = new BigDecimal("50.0000");
        System.out.println(bigDecimal8.toString()); //50.0000
        BigDecimal bigDecimal9 = new BigDecimal("105.0000");
        System.out.println(bigDecimal9); //105.0000




    }
}
