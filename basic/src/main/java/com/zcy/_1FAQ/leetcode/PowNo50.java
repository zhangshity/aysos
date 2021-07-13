package com.zcy._1FAQ.leetcode;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 11:15 2018/12/3
 * @ Modified: By:
 * <p>
 * ================================================================================
 * -Description:
 * -
 * Implement pow(x, n), which calculates x raised to the power n * (x^n).
 * <p>
 * Example 1:
 * Input: 2.00000, 10
 * Output: 1024.00000
 * <p>
 * Example 2:
 * Input: 2.10000, 3
 * Output: 9.26100
 * <p>
 * Example 3:
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * Note:
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 * <p>
 * ================================================================================
 * -描述:
 * -
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * ================================================================================
 */

public class PowNo50 {

    //解答
    public double myPow(double x, int n) {

        if ((-100) < x && x < 100 &&
                Integer.MIN_VALUE < n && n < Integer.MAX_VALUE) { //判断输入参数范围

            double result = 1;

            if (n > 0) {//正数次幂
                for (int i = 1; i <= n; i++) {
                    result = result * x;
                }
                return result;
            } else if (n == 0) {//零次幂
                return result;
            } else {//负数次幂
                n = -n;
                for (int i = 1; i <= n; i++) {
                    result = result * x;
                }
                return 1 / result;
            }
        } else {
            return 0;
        }
    }


    //参考答案

}
