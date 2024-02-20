package com.zcy.collection;

import java.util.Arrays;
import java.util.Collections;

public class ArrayTest {
    public static void main(String[] args) {

        int[] a = new int[0];
        System.out.println(Arrays.toString(a)); //[]
        System.out.println(a[0]); //下标越界

        int[] a1 = new int[1];
        System.out.println(Arrays.toString(a1)); //[0]
        System.out.println(a1[0]); //0
        //System.out.println(a1[1]);//下标越界

        int[] a2 = new int[]{1,2};
        System.out.println(Arrays.toString(a2)); //[1, 2]
        System.out.println(a2[0]); //1

    }

}
