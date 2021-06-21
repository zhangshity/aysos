package com.zcy._1FAQ.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @ Author: chunyang.zhang
 * @ Description: review
 * @ Date: Created in 18:37 2020/7/13
 * @ Modified: By:
 */
public class BubbleSortAndTuning {

    public static void bubbleSort(Integer[] array) {
        //控制循环轮数
        for (int i = 0; i < array.length; i++) {
            //控制左右比较
            for (int j = 0; j < array.length - (i + 1); j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "次循环: " + Arrays.toString(array));
        }
    }

    public static void bubbleSortTuning(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - (i + 1); j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
            System.out.println("第" + (i + 1) + "次循环: " + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 4, 6, 9, 8, 7, 1, 3);
        Integer[] a = (Integer[]) list.toArray();
        Integer[] b = (Integer[]) list.toArray();

        
        System.out.println("数组:" + list);
        System.out.println("==========数组的冒泡排序============");
        bubbleSort(a);
        System.out.println("==========数组的冒泡排序（优化）============");
        bubbleSortTuning(b);
    }
}
