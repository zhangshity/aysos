package com.zcy._1FAQ.leetcode;

/**
 * @ Author: chunyang.zhang
 * @ Description: 给定两个数组A[]、B[],算出B数组是否为A数组的子数组，返回子数组的下标,不是返回-1 (如果有多个子数组，返回最后一个的下标)
 * @ Date: Created in 21:17 2020/7/9
 * @ Modified: By:
 */
public class SubArray {


    public static int Sub(int[] A, int[] B) {
        //定义返回值
        int result = -1;
        //B的遍历下标
        int i = 0;

        //遍历比较
        for (int j = 0; j < A.length; j++) {
            if (B[i] == A[j]) {
                result = j;
                int n = i;
                int m = j;
                do {
                    if (B[n] != A[m]) {
                        result = -1;
                    }
                    n++;
                    m++;
                } while (n < B.length);
            }
        }

        return result;
    }


    public static void main(String[] args) {

        System.out.println(Sub(new int[]{4, 5, 6, 7, 5, 6, 7}, new int[]{9})); //-1
        System.out.println(Sub(new int[]{4, 5, 6, 7}, new int[]{6})); //2
        System.out.println(Sub(new int[]{4, 5, 6}, new int[]{5, 6})); //1
        System.out.println(Sub(new int[]{4, 5, 6, 7, 5, 6, 7}, new int[]{5, 6})); //4

    }
}
