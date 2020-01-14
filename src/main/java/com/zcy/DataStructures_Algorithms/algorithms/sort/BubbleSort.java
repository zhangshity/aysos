package com.zcy.DataStructures_Algorithms.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 冒泡排序
     * <p>
     * 1.进行多轮即(循环轮数为数组长度)
     * 2.每轮中,从第一个数开始,与右边的数字比较,大于右边数字就交换,否则不变
     * ........从第二个数开始,与右边的数字比较,大于右边数字就交换,否则不变
     * ........从第三个数开始,与右边的数字比较,大于右边数字就交换,否则不变
     * ........从第四个数开始,与右边的数字比较,大于右边数字就交换,否则不变
     * ...
     * ........从第n个数开始,与右边的数字比较,大于右边数字就交换,否则不变(n=arr.length-1)
     * <p>
     * <p>
     * 3.每次都会把一个最大数字放到最末尾,即下次左右比较的次数减一,第i轮循环次数为数组长度减i
     * 最后一次左右比较,右边的j+1小于数组长度 (j+1 = arr.length-i) 故 (j=arr.length-i-1)
     *
     * @param arr
     * @return
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
     * 上述排序,第四轮就完成了排序,故加入标准为判断是否有左右交换,无则退出排序
     *
     * @param arr
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
