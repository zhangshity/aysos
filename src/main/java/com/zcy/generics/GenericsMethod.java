package com.zcy.generics;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《泛型测试》
 * @ Date: Created in 10:22 2019-07-23
 * @ Modified: By:
 */
public class GenericsMethod {

    private static <E> void printArray(E[] array) {
        //foreach遍历数组
        for (E e : array) {
            System.out.println("数组为: " + e);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //创建不同
    }

}
