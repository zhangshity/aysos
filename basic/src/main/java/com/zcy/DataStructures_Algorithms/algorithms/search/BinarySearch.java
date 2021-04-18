package com.zcy.DataStructures_Algorithms.algorithms.search;

import java.util.Arrays;

/**
 * @ Author: chunyang.zhang
 * @ Description: 二分查找复习
 * @ Date: Created in 22:52 2020/7/13
 * @ Modified: By:
 */
public class BinarySearch {


    /**
     * 输入数组[],数组中的某个数字num,利用二分法查找到数组的位置并返回 (数组默认有序)
     *
     * @param array 整型数组
     * @param num   数组中整型数字
     * @return 数组中数字的位置
     */
    public static int binarySearch(int[] array, int beginIndex, int endIndex, int num) {
        //beginIndex = 0;
        //endIndex = array.length - 1;
        int middleIndex = (beginIndex + endIndex) / 2;
        if (num == array[middleIndex]) {
            return middleIndex;
        } else if (num > array[middleIndex]) {
            return binarySearch(array, middleIndex, array.length - 1, num);
        } else if (num < array[middleIndex]) {
           return binarySearch(array, 0, middleIndex, num);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 7, 8, 23, 57, 78, 119, 200,233,566,567,656,868,999,1234};
        Arrays.sort(a);

        int result = binarySearch(a, 0, a.length - 1, 119);
        System.out.println("Result index = " + result);
    }
}
