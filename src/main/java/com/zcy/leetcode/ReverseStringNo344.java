package com.zcy.leetcode;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:15 2018/12/3
 * @ Modified: By:
 * <p>
 * ================================================================================
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example 1:
 * <p>
 * Input: "hello"
 * Output: "olleh"
 * Example 2:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 * <p>
 * ================================================================================
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 * ================================================================================
 */

public class ReverseStringNo344 {

    //解答
    public String reverseString(String s) {

        String result = "";

        for (int i = s.length(); i > 0; i--) {
            //pop
            String temp = s.substring(i - 1, i);

            //push
            result = result.concat(temp);
        }
        return result;
    }

    //参考1
    public String reverseString2(String s) {

        StringBuilder sb = new StringBuilder(s);
        String afterreverse = sb.reverse().toString();
        return afterreverse;
    }

    //参考2
    public String reverseString3(String s) {
        int length = s.length();
        String reverse = "";
        for (int i = 0; i < length; i++)
            reverse = s.charAt(i) + reverse;
        return reverse;
    }


}
