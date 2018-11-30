package com.zcy.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntegerTest {

    @Test
    public void reverse() {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-123));

    }


    @Test
    public void newReverse() {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.newReverse(1534236469));
    }

    @Test
    public void reverseAnswer() {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverseAnswer(1534236469));
    }
}