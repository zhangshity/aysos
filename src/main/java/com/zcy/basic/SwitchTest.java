package com.zcy.basic;

public class SwitchTest {
    public static void main(String[] args) {
        int i = 1;
        String result = "";
        switch (i) {
            case 1:
                result = result + "him ";
            case 2:
                result = result + "her ";
            case 3:
                result = result + "it ";
            default:
                result = result + "me ";
        }
        System.out.println(result);
    }
}
