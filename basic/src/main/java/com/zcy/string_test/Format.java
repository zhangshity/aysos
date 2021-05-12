package com.zcy.string_test;

public class Format {
    public static void main(String[] args) {

        Integer number = 345;
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        String format = String.format("%06d", number);

        System.out.println(format); //000345

    }
}
