package sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * <p><a href="https://blog.csdn.net/qq_35344198/article/details/106471672">CSDN博客</a>
 * <p><a href="https://www.runoob.com/w3cnote/selection-sort.html">菜鸟教程</a>
 */
public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 8, 5, 4, 7, 9, 1, 3};
        selectionSort(arr);
    }


    // 选择排序（小->大）
    public static void selectionSort(int[] array) {
        // 所有变量均为下标
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;                                    // 初始化最小数索引:比较初始值
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {                // 寻找最小数
                    min = j;                                // 标记最小数索引
                }
            }

            // 最大值最小值交换swap
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }

        System.out.println(Arrays.toString(array));
    }


}
