package com.zcy.DataStructures_Algorithms.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {
    //参考:https://www.jianshu.com/p/88759596c944

    /**
     * 冒泡排序
     * <p>
     * 1.进行多轮即(循环轮数为数组长度)
     * 2.每轮中,第一个数字,与右边的数字(第二个数字)比较,大于右边数字就交换,否则不变
     * ........第二个数字,与右边的数字(第三个数字)比较,大于右边数字就交换,否则不变
     * ........第三个数字,与右边的数字(第四个数字)比较,大于右边数字就交换,否则不变
     * ........第四个数字,与右边的数字(第五个数字)比较,大于右边数字就交换,否则不变
     * ...
     * ........第n个数字,与右边的数字比较,大于右边数字就交换,否则不变(n=arr.length-1)
     * <p>
     * <p>
     * 3.每次都会把一个最大数字放到最末尾,即下次左右比较的次数减一,第n轮(i+1)循环比较次数为数组长度减n(arr.length-(i+1))
     * - > (i从0开始,而模型n从1开始故n=i+1)
     * <p>
     * 另一种理解方式:最后一次左右比较,右边的j+1小于数组长度 (j+1 = arr.length-i) 故 (j=arr.length-i-1)
     *
     * @param arr 整型数组
     * @see com.zcy.leetcode.BubbleSortAndTuning#bubbleSort(Integer[])
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) { //控制循轮数
            for (int j = 0; j < arr.length - i - 1; j++) { //控制每轮左右比较次数
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "轮后: " + Arrays.toString(arr));
        }
    }


    /**
     * 冒泡排序优化
     * <p>
     * 上述排序,第四轮就完成了排序,但是程序依然在进行比较，故需要优化。
     * Tuning: 在外层for控制循环次数层内,加入标志<code>boolean</code>flag(判断有无左右交换),无交换break出循环
     *
     * @param arr 整型数组
     * @see com.zcy.leetcode.BubbleSortAndTuning#bubbleSortTuning(Integer[])
     */
    public static void tuningBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean tag = false; //标志位
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    tag = true; //做了左右交换就改变
                }
            }
            if (tag == false) { //没做左右交换(标志位不变),跳出循环
                break;
            }
            System.out.println("第" + (i + 1) + "轮后: " + Arrays.toString(arr));
        }
    }


    public static void main(String[] args) {
        int[] a = {3, 9, 1, 4, 2, 7, 8, 6, 5};
        System.out.println(Arrays.toString(a));
        bubbleSort(a);

        int[] b = {3, 9, 1, 4, 2, 7, 8, 6, 5};
        System.out.println(Arrays.toString(b));
        tuningBubbleSort(b);
    }

}
