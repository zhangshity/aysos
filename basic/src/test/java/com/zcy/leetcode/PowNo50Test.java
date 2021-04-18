package com.zcy.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PowNo50Test {

    @Test
    public void myPow() {
        PowNo50 powNo50 = new PowNo50();
        double result = powNo50.myPow(0.00001, 2147483647);
        System.out.println("result: " + result);
//        Assert.assertEquals(1024, result);

    }

}