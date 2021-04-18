package com.zcy.variable;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 14:33 2019/10/23
 * @ Modified: By:
 * <p>
 * 根据一傻逼公司的傻逼面试题的回忆，测试
 */
public class ShortVariableTest {

    public static void main(String[] args) {
        //1.无法通过编译，未赋初值
//        short s1;
//        s1 = s1 + 1;

        //2.short类型和int不匹配
//        short s2 = 1;
//        s2 = s2 + 1;

        //无错
        short s3 = 1;
        s3 += s3;

    }
}
