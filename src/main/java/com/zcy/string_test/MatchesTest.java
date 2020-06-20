package com.zcy.string_test;

public class MatchesTest {
    public static void main(String[] args) {

        String s = "1asc";
        String s1 = "1desc";
        String s2 = "123456desc";
        String s3 = "";
        String s4 = "asda";
        String s5 = "{!~$!@$%zfzf";
        String snull = null;

        test(s1);
    }

    private static void test(String str) {
        System.out.println("endsWith(\"asc\") " + str.endsWith("asc"));
        System.out.println("endsWith(\"desc\") " + str.endsWith("desc"));
        System.out.println("endsWith(\"asc\") ||endsWith(\"desc\") " + (str.endsWith("asc") || str.endsWith("desc")));


        System.out.println(str.matches("[0-9].*"));
        System.out.println(str.matches("[0-9][a-z].*"));
        System.out.println((str.matches("[0-9][a-z][a-z][a-z]") || str.matches("[0-9][a-z][a-z][a-z][a-z]")));

    }
}
