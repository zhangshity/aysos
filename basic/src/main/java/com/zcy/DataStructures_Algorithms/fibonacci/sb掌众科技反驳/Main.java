package com.zcy.DataStructures_Algorithms.fibonacci.sb掌众科技反驳;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Fbnc fbncFunction = new Fbnc();

        //1.Fbnci's correct number （e.g. F100=354224848179261915075）
        BigInteger result1 = fbncFunction.fbShulie1(3); //太过占用内存，大数据不可用
        System.out.println("递归嵌套 >" + result1);

        BigInteger result2 = fbncFunction.fbShulie2(100);
        System.out.println("数组 >" + result2);

        BigInteger result3 = fbncFunction.fbShulie3(100);
        System.out.println("平推 >" + result3);


        //2.Get first 1000 number in Fibnci
        int seqFn = fbncFunction.getFirst1000No();
        System.out.println("第一个值过1000的项为：第" + seqFn + "项");
    }
}


