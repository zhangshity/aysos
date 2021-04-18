package com.zcy.DataStructures_Algorithms.fibonacci.sb掌众科技反驳;

import java.math.BigInteger;

public class Fbnc {

    public BigInteger fbShulie1(int n) {
        if (n < 0) {
            throw new RuntimeException("Wrong args,please check your arguments");
        }
        if (n == 0) {
            return BigInteger.valueOf(0);
        } else if (n == 1) {
            return BigInteger.valueOf(1);
        } else if (n >= 2) {
            return (fbShulie1(n - 1).add(fbShulie1(n - 2)));
        }
        throw new RuntimeException("Unknown Error!");
    }

    public int getFirst1000No() {
        int n = 0;
        for (int i = 0; fbShulie1(i).longValue() < 1000; i++) {
            n = i;
        }
        return n + 1;
    }

    public BigInteger fbShulie2(int n) {
        BigInteger[] a = new BigInteger[n + 1];
        a[0] = BigInteger.valueOf(0);
        a[1] = BigInteger.valueOf(1);
        for (int i = 2; i < n + 1; i++) {
            a[i] = a[i - 1].add(a[i - 2]);
        }
        return a[n];
    }


    public BigInteger fbShulie3(int n) {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = null;
        for (int i = 2; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }
}
