package com.zcy.desgin_pattern.singleton._review2020_0515;

public class Car {

    private Car() {
    }

    private static Object o = null;

    public static synchronized Object getCar() {
        if (o == null) {
            o = new Car();
            return o;
        } else {
            return o;
        }
    }


    public static void main(String[] args) {
        System.out.println(getCar());
    }
}
