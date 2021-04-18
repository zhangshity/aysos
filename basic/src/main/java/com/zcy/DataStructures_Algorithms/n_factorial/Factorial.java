package com.zcy.DataStructures_Algorithms.n_factorial;

import java.math.BigInteger;

public class Factorial {


    public static BigInteger getFactorialNormal(int n) {
        BigInteger init = BigInteger.valueOf(1);
        for (int i = 0; i < n; i++) {
            init = init.multiply(BigInteger.valueOf(i + 1));
        }
        return init;
    }

    public static int getgetFactorialArray(int n) {
        int[] a = new int[1000000000];
        a[0] = 1;
        //TODO 阶乘数组存放大数据
//        for (int i = 0; i < n; i++) {
//            a[]
//        }
        return 0;
    }


    public static BigInteger getFactorialCircle(int n) {
        BigInteger init = BigInteger.valueOf(1);
        if (n == 0 || n == 1) {
            return BigInteger.valueOf(1);
        } else if (n >= 2) {
            return getFactorialCircle(n - 1).multiply(BigInteger.valueOf(n));
        }
        throw new RuntimeException("Error!");
    }

    public static void main(String[] args) {
        System.out.println(getFactorialNormal(100));
        System.out.println(getFactorialCircle(100));
    }
}
