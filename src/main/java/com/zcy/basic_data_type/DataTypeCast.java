package com.zcy.basic_data_type;

/**
 * @ Author: chunyang.zhang
 * @ Description: <>变量自动类型转化</>
 * @ Date: Created in 03:14 2019/11/8
 * @ Modified: By:
 * <p>
 * <p>
 * 整型、实型（常量）、字符型数据可以混合运算。运算中，不同类型的数据先转化为同一类型，然后进行运算。
 * <p>
 * |转换从低级到高级：
 * |
 * |低  ------------------------------------>  高
 * |byte,short,char—> int —> long—> float —> double
 */
public class DataTypeCast {
    //    数据类型转换必须满足如下规则：
    //            1.不能对boolean类型进行类型转换。
    //            2.不能把对象类型转换成不相关类的对象。
    //            3.在把容量大的类型转换为容量小的类型时必须使用强制类型转换。
    //            4.转换过程中可能导致溢出或损失精度，例如：
    public static void main(String[] args) {

        //溢出(b=-128)
        int i = 128;
        byte b = (byte) i;
        System.out.println(b);


    }

}
