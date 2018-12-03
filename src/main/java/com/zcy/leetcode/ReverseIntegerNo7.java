package com.zcy.leetcode;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 15:06 2018/11/28
 * @ Modified: By:
 * <p>
 * ================================================================================
 * -Description:
 * -
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 * `````Input: 123
 * `````Output: 321
 * Example 2:
 * `````Input: -123
 * `````Output: -321
 * Example 3:
 * `````Input: 120
 * `````Output: 21
 * Note:
 * `````Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * `````For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <p>
 * <p>
 * ================================================================================
 * -描述:
 * -
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * `````输入: 123
 * `````输出: 321
 * 示例 2:
 * `````输入: -123
 * `````输出: -321
 * 示例 3:
 * `````输入: 120
 * `````输出: 21
 * 注意:
 * `````假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
 * `````请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * <p>
 * <p>
 * <p>
 * ================================================================================
 * !!!!总结:（in mind）
 * -
 * `````数/对应量级=首位数
 * ```````````例:int x = 123/100;    得到x=1
 * ``````````````int x = 4312/1000;  得到x=4
 * ``````````````int x = 54/10;      得到x=5
 * -
 * `````数%对应量级=除去首位数剩下的数
 * ```````````例:int y = 123%100;    得到y=23
 * ``````````````int y = 4312%1000;  得到y=312
 * ```````````````int y = 54%10;      得到y=4
 */


public class ReverseIntegerNo7 {

    //测试成立 但仅限于 3位数内新算法另外写
    public int reverse(int x) {

        //溢出范围计算
        int minCount = 2;
        for (int i = 1; i < 31; i++) {
            minCount = minCount * 2;
        }
        int maxCount = 2;
        for (int i = 1; i < 31; i++) {
            maxCount = maxCount * 2;
        }


        //变量设置
        int min = 0 - minCount;
        int max = maxCount - 1;
        int temp[] = {0, 0, 0};
        int t;   //交换中间变量
        int result;

        if (x < 10 && x > -10) {//一位数直接输出

            result = x;

        } else if (x >= 10 && x < 100 || x <= -10 && x > -100) {//两位数交换两位,判断正负
            if (x > 0) {
                //1取值
                int i = x / 10;
                int j = x % 10;

                t = i;
                i = j;
                j = t;

                result = i * 10 + j;

            } else {
                x = (-1) * x;

                int i = x / 10;
                int j = x % 10;

                t = i;
                i = j;
                j = t;

                result = (-1) * (i * 10 + j);

            }


        } else {//三位数交换 首末 两位,判断正负
            if (x > 0) {

                //1取值
                int i = x / 100;
                int j = x % 100 / 10;    //取数逻辑见上面总结( / 和 % 的使用)
                int k = x % 100 % 10;

                //2暂存到数组
                temp[0] = i;
                temp[1] = j;
                temp[2] = k;

                //3处理数据,进行反转(三位数只换首位)
                t = temp[0];
                temp[0] = temp[2];
                temp[2] = t;

                //4写回变量
                result = temp[0] * 100 + temp[1] * 10 + temp[2];

            } else {

                x = (-1) * x;

                //1取值
                int i = x / 100;
                int j = x % 100 / 10;    //取数逻辑见上面总结( / 和 % 的使用)
                int k = x % 100 % 10;

                //2暂存到数组
                temp[0] = i;
                temp[1] = j;
                temp[2] = k;

                //3处理数据,进行反转(三位数只换首位)
                t = temp[0];
                temp[0] = temp[2];
                temp[2] = t;

                //4写回变量
                result = (-1) * (temp[0] * 100 + temp[1] * 10 + temp[2]);

            }

        }

        //5判断是否越界
        if (result <= min || result >= max) {
            return 0;
        } else {//6输出
            return result;
        }


    }


    //弹出,插入思想(堆栈)
    public int newReverse(int x) {
        int pop = 0;  //存放头部弹出数字
        int rec = 0;  //存放拼接数字


        while (x != 0) {
            pop = x % 10;
            x = x / 10;

            if (rec > Integer.MAX_VALUE / 10 || (rec == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rec < Integer.MIN_VALUE / 10 || (rec == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

//          rec = pop * 10 + rec; //注意理解这样做为什么错
            rec = rec * 10 + pop;
        }


        return rec;
    }


    //参考解答
    public int reverseAnswer(int x) {

        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    //实际使用的Java包装类Integer.reverse()方法
    public void demoReverse() {
        Integer.reverse(12); //通过位的反转顺序,指定的int值而得到的值
    }

}
