package com.zcy.leetcode;

/**
 * @ Author: chunyang.zhang
 * @ Description: n阶台阶，每次只能跳1阶或2阶，问：有几种跳法？
 * @ Date: Created in 19:33 2021/3/21
 * @ Modified: By:
 */


public class Tencent1 {
    public static void main(String[] args) {
//        1 * x + 2 * (n-x) = n;

        // 1jie : 1
        // 2jie : 1 + 1 = 2
        // 3jie : 1 + 1 + 1 = 3
        // 4jie : 1 + 1 + 1 + 1 = 5
        // 5jie : 8???
        // 6jie : 13??
        // 7            21


//        if (n == 1) {
//            return 1;
//        } else if (n == 2) {
//            return 2;
//        } else if (n = 3) {
//            returna
//        }
        System.out.println("跳法:" + countSkipWay(7) + "种");

    }

    // n阶台阶
    public static int countSkipWay(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n > 2) {
            return countSkipWay(n - 1) + countSkipWay(n - 2);
        } else {
            throw new RuntimeException(" error stage");
        }
    }



}
