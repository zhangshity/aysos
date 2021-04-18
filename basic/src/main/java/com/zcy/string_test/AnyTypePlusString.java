package com.zcy.string_test;

public class AnyTypePlusString {
    public static void main(String[] args) {

        String s = System.currentTimeMillis() + "";

        System.out.println(1L + "");

        Long l1 = 2L;

        String s1 = l1 + "";
        String s2 = "2";
        String s3 = String.valueOf(l1);
        System.out.println(s1.equals(s2));
        System.out.println(l1.equals(s2));
        System.out.println(s2.equals(s3));
    }
}
