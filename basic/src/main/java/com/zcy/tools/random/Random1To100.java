package com.zcy.tools.random;

import java.util.Random;

/**
 * @ Author: chunyang.zhang
 * @ Description: 傻逼公司的傻逼面试题
 * @ Date: Created in 15:53 2019/10/23
 * @ Modified: By:
 */
public class Random1To100 {

    public static void main(String[] args) {
        /**
         * 随机生成1-100之间的整数
         */

        //==================== Thinking思路 >>>>>>>============================
        //调用Math的随机数方法random(),返回的是double型 [0,1)
        double randomNumber = Math.random();
        System.out.println(randomNumber);
        //Method1: 直接乘100，再转化为int
        int m1Result = new Double(randomNumber * 100).intValue();
        int m11Result = (int) (randomNumber * 100);
        System.out.println(m1Result);
        System.out.println(m11Result);
        //================================================
        //Mehtod2: 利用util工具函数
        Random random = new Random();
        int m2Result = random.nextInt(100);
        System.out.println(m2Result);
        //==================== <<<<<<< Thinking思路============================


        /**
         * 解答
         */
        System.out.println("答案============>>>>>>>>>>>>>");

        int num1 = new Random().nextInt(100);
        int num2 = (int) (Math.random() * 100);

        System.out.println(num1);
        System.out.println(num2);
    }
}
