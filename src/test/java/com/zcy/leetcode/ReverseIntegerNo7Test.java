package com.zcy.leetcode;

import org.junit.Test;

public class ReverseIntegerNo7Test {

    @Test
    public void reverse() {
        ReverseIntegerNo7 reverseIntegerNo7 = new ReverseIntegerNo7();
        System.out.println(reverseIntegerNo7.reverse(-123));

    }


    @Test
    public void newReverse() {
        ReverseIntegerNo7 reverseIntegerNo7 = new ReverseIntegerNo7();
        System.out.println(reverseIntegerNo7.newReverse(1534236469));
    }

    @Test
    public void reverseAnswer() {
        ReverseIntegerNo7 reverseIntegerNo7 = new ReverseIntegerNo7();
        System.out.println(reverseIntegerNo7.reverseAnswer(1534236469));
    }
}