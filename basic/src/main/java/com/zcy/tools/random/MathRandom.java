package com.zcy.tools.random;

import java.lang.Math;//lang可以默认省略
import java.util.Random;

public class MathRandom {
    public static void main(String[] args) {

        /**
         * Math 为final工具类,方法均为static
         */
        Double d = Math.random(); //返回[0,1)之间的随机浮点型
        System.out.println("Math.random() >>> " + d);


        /**
         * Random类
         */
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println(i);
    }
}
