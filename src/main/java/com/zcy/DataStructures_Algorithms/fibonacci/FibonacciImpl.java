package com.zcy.DataStructures_Algorithms.fibonacci;

import java.math.BigInteger;

public class FibonacciImpl {

    public static BigInteger[] getFibonacciSequenceArray(int n) {
        BigInteger[] a = new BigInteger[n+1];
        a[0] = BigInteger.valueOf(0);
        a[1] = BigInteger.valueOf(1);
        for (int i = 2; i < n+1; i++) {
            a[i] = a[i - 2].add(a[i - 1]);
        }
        return a;
    }

    public static BigInteger getFibonacciSequenceFn(int n) {
        BigInteger[] a = new BigInteger[n+1];
        a[0] = BigInteger.valueOf(0);
        a[1] = BigInteger.valueOf(1);
        for (int i = 2; i < n+1; i++) {
            a[i] = a[i - 2].add(a[i - 1]);
        }
        return a[n];
    }


    public static void main(String[] args) {
        BigInteger[] a = getFibonacciSequenceArray(200);
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }

        BigInteger result = getFibonacciSequenceFn(200);
        System.out.println(result);
    }
}
