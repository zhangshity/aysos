package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * <p><a href="https://blog.csdn.net/qq_35344198/article/details/106437639">CSDN博客</a>
 * <p><a href="https://www.runoob.com/w3cnote/bubble-sort.html">菜鸟教程</a>
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 8, 5, 4, 9, 1, 3};
        bubbleSort(arr);
    }


    // 冒泡排序（小->大）
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length -1 ; i++) {              // 外：空置比较次数（最多长度-1次）
            for (int j = 0; j < array.length - 1 -1; j++) {       // 内：控制左右比较
                if (array[j] > array[j + 1]) {                 //大于则交换(冒上去)
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j + 1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }


}
