package com.zcy.desgin_pattern.singleton._review2020_0515;

public class Apple {

    private Apple() {
    }

    private static Object o = new Apple();

    public static synchronized Object getApple() {
        return o;
    }


    public static void main(String[] args) {
        System.out.println(getApple());
    }
}
