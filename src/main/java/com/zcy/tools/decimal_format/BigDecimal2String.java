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


        System.out.println(bigDecimal); //1233.12879999999995561665855348110198974609375
        System.out.println(bigDecimal2); //1233.128800
        System.out.println(bigDecimal3); //1233.1288
        System.out.println(bigDecimal4); //1233.1288
        System.out.println(bigDecimal5); //1233.1288
        System.out.println(bigDecimal2.doubleValue()); //1233.1288

//        System.out.println(bigDecimal.toString());
//        System.out.println(bigDecimal2.toString());
        System.out.println("=================================================");
        double d = 12.30;
        String doubleStr = Double.toString(d);
        System.out.println(d); //12.3
        System.out.println(doubleStr); //12.3



        System.out.println("==================== BigDecimal构造函数valueOf(long ) 会缓存0-10的整数=============================");
        BigDecimal val0 = BigDecimal.valueOf(0);   System.out.println(val0);  //0
        BigDecimal val1 = BigDecimal.valueOf(1);   System.out.println(val1);  //1
        BigDecimal val2 = BigDecimal.valueOf(2);   System.out.println(val2);  //2
        BigDecimal val3 = BigDecimal.valueOf(3);   System.out.println(val3);  //3
        BigDecimal val4 = BigDecimal.valueOf(4);   System.out.println(val4);  //4
        System.out.println("==================== BigDecimal构造函数valueOf(long unscaledVal, int scale) 会缓存0-0E-15的小数(小数点后15位)=============================");
        BigDecimal unscaledVal0 = BigDecimal.valueOf(0, 0);    System.out.println(unscaledVal0);  //0
        BigDecimal unscaledVal1 = BigDecimal.valueOf(0, 1);    System.out.println(unscaledVal1);  //0.0
        BigDecimal unscaledVal2 = BigDecimal.valueOf(0, 2);    System.out.println(unscaledVal2);  //0.00
        BigDecimal unscaledVal3 = BigDecimal.valueOf(0, 3);    System.out.println(unscaledVal3);  //0.000
        BigDecimal unscaledVal6 = BigDecimal.valueOf(0, 6);    System.out.println(unscaledVal6);  //0.000000
        BigDecimal unscaledVal7 = BigDecimal.valueOf(0, 7);    System.out.println(unscaledVal7);  //0E-7
        BigDecimal unscaledVal8 = BigDecimal.valueOf(0, 8);    System.out.println(unscaledVal8);  //0E-8
        BigDecimal unscaledVal9 = BigDecimal.valueOf(0, 9);    System.out.println(unscaledVal9);  //0E-9
        BigDecimal unscaledVal10 = BigDecimal.valueOf(0, 10);  System.out.println(unscaledVal10); //0E-10
        BigDecimal unscaledVal15 = BigDecimal.valueOf(0, 15);  System.out.println(unscaledVal15); //0E-15





        System.out.println("====================BigDecimal 比较=============================");
        BigDecimal b1 = new BigDecimal("123.5");
        BigDecimal b2 = new BigDecimal("123.50");
        System.out.println("b1=" + b1 + "  b2=" + b2 + "    -> result of equals():" + b1.equals(b2)); //false
        System.out.println("b1=" + b1 + "  b2=" + b2 + "    -> result of compareTo():" + (b1.compareTo(b2) == 0)); //true

        //与0比较
        BigDecimal bd1 = new BigDecimal("0.00");
        System.out.println(bd1.compareTo(BigDecimal.ZERO) == 0); //true
        System.out.println(bd1.doubleValue() == 0); //true

        BigDecimal bd2 = new BigDecimal("0.0000");
        System.out.println("bd2=" + bd2 + "  bd2.doubleValue()=" + bd2.doubleValue());

        System.out.println(bd2.compareTo(BigDecimal.ZERO) == 0); //true
        System.out.println(bd2.doubleValue() == 0); //true

        double dd = 0.000;
        int dd2 = 0;
        System.out.println(dd + " " + dd2 + " " + (dd == dd2));


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



        // =========================== 整数小数分离 测试 ==============================================================
        System.out.println("=========================== 整数小数分离 测试 ==============================================================");
        BigDecimal bigDecimal10 = new BigDecimal("123.56");
        BigDecimal[] twoParts = bigDecimal10.divideAndRemainder(BigDecimal.ONE);
        BigDecimal integerPart = twoParts[0];
        BigDecimal decimalPart = twoParts[1];

        System.out.println("待分离测试数据: " + bigDecimal10);
        System.out.println("整数部分: "+integerPart);
        System.out.println("小数部分: "+decimalPart);
    }
}
