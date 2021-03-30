package com.zcy.basic_data_type;

/**
 * <p>@ Author: chunyang.zhang
 * <p>@ Description: 《变量自动类型转化》
 * <p>@ Date: Created in 03:14 2019/11/8
 * <p>@ Modified: By:
 * <p>
 * <p>
 * 整型、实型（常量）、字符型数据可以混合运算。运算中，不同类型的数据先转化为同一类型，然后进行运算。
 * <p>
 * <p> |转换从低级到高级：
 * <p> |
 * <p> |低  ------------------------------------>  高
 * <p> |byte,short,char—> int —> long—> float —> double
 */
public class DataTypeCast {
    //    数据类型转换必须满足如下规则：
    //            1.不能对boolean类型进行类型转换。
    //            2.不能把对象类型转换成不相关类的对象。
    //            3.在把容量大的类型转换为容量小的类型时必须使用强制类型转换。
    //            4.转换过程中可能导致溢出或损失精度，例如：
    public static void main(String[] args) {

        // 大转小 (强制类型转换)
        int i = 128;
        byte b = (byte) i; //溢出 byte取值[-128,127]
        System.out.println(b); //-128

        // 小转大 (自动类型转换)
        int j = 789;
        long d = j;
        System.out.println(d); //789
    }

    /**
     * Supp.
     * <p>浮点型在内存中占用的是4个字节的空间，而long型占用的是8个字节的空间。可是为什么4个字节的float型的最大值会大于long型的最大值呢？
     * <p>
     * <p> long:  在内存中占8个字节，共64位。第1位符号位; 接下来63位为数值位,它表示的数值有2的63次方; 平分正负，数值范围是 [-2^63 , 2^63-1]
     * <p> float: 在内存中占4个字节，共32位。第1位符号位; 接下来的8位为指数域; 剩下的23位为小数域。(也就是说，浮点数在内存中的二进制值不是直接转换为十进制数值的，而是按照上述公式计算而来，通过这个公式，虽然只用到了4个字节，但是浮点数却比长整型的最大值要大。)
     * <p>
     * <p> (归根结底，long存放的是数值，而float存放的则是一种逻辑规则。  (-1)^sign × fraction × 2^exponent
     * <p>（exponent中存储的数值是0（-127+127）到255（128+127））
     * <p>
     * <p> 参考: https://blog.csdn.net/realYuzhou/article/details/106961396
     */
    public void misc() {
    }

}
