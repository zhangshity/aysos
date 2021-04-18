package com.zcy.basic;


import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] i = new int[5]; //不符值默认都是零
        System.out.println(i[0]);
        System.out.println(i[1]);
        System.out.println(i[2]);
        System.out.println(i[3]);
        System.out.println(i[4]);

        //==================================
        System.out.println("==========foreach遍历数组============");
        for (int value : i) {
            System.out.println(value);
        }


        //============================ byte[] 和 String的转换测试 ====================================
        System.out.println("============================ byte[] 和 String的转换测试 ====================================");
        //序列化
        String serial = "Hi,123q@";
        byte[] bytes = serial.getBytes();

        System.out.println(bytes); //[B@bc92429f  //数组无toString()方法,默认打印hashcode
        System.out.println(Arrays.toString(bytes)); //[72, 105, 44, 49, 50, 51, 113, 64]
        System.out.println(new String(bytes));

    }


}
