package com.zcy.leetcode;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @ Author: chunyang.zhang
 * @ Description: 超级大数据的运算(不使用BigInteger和BigDecimal)
 * @ Date: Created in 21:48 2020/7/9
 * @ Modified: By:
 */
public class BigIntegerDIY {

    /**
     * @param arg1 大数据整型数字1(放在String中)
     * @param arg2 大数据整型数字2(放在String中)
     * @return String
     */
    public static String add(String arg1, String arg2) {
        if (!arg1.matches("^[0-9]*$") || !arg2.matches("^[0-9]*$")) {
            return "ERROR";
        }

        //分解为char数组
        char[] a = arg1.toCharArray();
        char[] b = arg2.toCharArray();

        //char数组转为int数组
        int[] c = new int[a.length];
        int[] d = new int[b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = Integer.parseInt(String.valueOf(a[i]));
        }
        for (int j = 0; j < b.length; j++) {
            d[j] = Integer.parseInt(String.valueOf(b[j]));
        }

        //运算(两个数位数相同)
        int[] result = new int[Math.max(c.length, d.length)];
        int carry = 0;
        for (int i = Math.max(c.length, d.length) - 1; i >= 0; i--) {
            result[i] = (c[i] + d[i] + carry) % 10;
            carry = (c[i] + d[i] + carry) / 10;
        }
        //运算(两个数位数不同) //TODO
//        int[] result = new int[Math.max(c.length, d.length)];
//        int carry = 0;
//        int i = Math.min(c.length, b.length);
//        int j = Math.max(c.length, b.length);
//
//        while (j >= 0) {
//            result[j] = c.length >= d.length ? (c[j] + (i >= 0 ? d[i] : 0) + carry) % 10 : ((i >= 0 ? c[i] : 0) + d[j] + carry) % 10;
//            carry = c.length >= d.length ? (c[j] + (i >= 0 ? d[i] : 0) + carry) / 10 : ((i >= 0 ? c[i] : 0) + d[j] + carry) / 10;
//            i--;
//            j--;
//        }


        //转为String
        StringBuilder sb = new StringBuilder("");
        for (int t = 0; t < result.length; t++) {
            sb.append(result[t]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String a = "1213344456435634562331242";
        String b = "3246435323472843553953491";
        System.out.println(add(a, b));
        //验证
        BigInteger b1 = new BigInteger(a);
        BigInteger b2 = new BigInteger(b);
        System.out.println(b1.add(b2));
    }
}
