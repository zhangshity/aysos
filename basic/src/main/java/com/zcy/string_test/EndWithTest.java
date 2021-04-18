package com.zcy.string_test;

public class EndWithTest {

    public static void main(String[] args) {

        String s = "12asc";
        String s1 = "1desc";
        String snull = null;

        test(s);
    }


    private static void test(String str) {
        System.out.println("endsWith(\"asc\") " + str.endsWith("asc"));
        System.out.println("endsWith(\"desc\") " + str.endsWith("desc"));
        System.out.println("endsWith(\"asc\") ||endsWith(\"desc\") " + (str.endsWith("asc") || str.endsWith("desc")));
    }
}
