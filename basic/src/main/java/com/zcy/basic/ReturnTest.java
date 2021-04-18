package com.zcy.basic;

public class ReturnTest {

    public static void main(String[] args) {
        System.out.println(value());
        System.out.println(add());
    }

    public static int value() {
        int num = 1;
        return num = 2;
    }

    public static int add() {
        int count = 0;
        return ++count;
    }


}
