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


        // Maybe NPE
        System.out.println(">>>> Maybe NPE <<<<");
        Integer i = null;
        String s4 = i + "";
        System.out.println("s4=" + s4
                + " ,and s4 instance of String :" + (s4 instanceof String)); //null 字符串
    }
}
