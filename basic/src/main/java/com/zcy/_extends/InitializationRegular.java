package com.zcy._extends;

public class InitializationRegular {

    private static int a;
    private static int b;
    private static int c;
    private static int d;
    private static int e;

    static {
        a = 1;
        b = 2;
        c = 3;
        d = 4;
        e = 5;
    }


    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    {
        f = 6;
        g = 7;
        h = 8;
        i = 9;
        j = 10;
    }


    public static void main(String[] args) {
        System.out.println("a=" + a + " b=" + b + " c=" + c + " d=" + d + " e=" + e);

        InitializationRegular clazz = new InitializationRegular();
        System.out.println("f=" + clazz.f + " g=" + clazz.g + " h=" + clazz.h + " i=" + clazz.i + " j=" + clazz.j);
    }
}
