package com.zcy.string_test;

public class NullPoninterTest {
    public static void main(String[] args) {


        String ss = null;
        if (ss != null && ss.equals("qwe")) {  // 不会空指针！
            System.out.println("测试");
        }


        String s = null;

        //System.out.println(s.length());
        System.out.println("ok");

    }
}
