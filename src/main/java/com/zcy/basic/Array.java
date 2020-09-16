package com.zcy.basic;

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
    }


}
