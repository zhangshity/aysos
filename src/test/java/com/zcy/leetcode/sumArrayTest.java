package com.zcy.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class sumArrayTest {

    //    给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
//
//    你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
//
//    示例:
//
//    给定 nums = [2, 7, 11, 15], target = 9
//
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]


    // public int[] twoSum(int[] nums, int target)
    @Test
    public void testOne() {
        TwoSumNo1 twoSumNo1 = new TwoSumNo1();
        //int[] nums = {2, 7, 11, 15};
        int[] nums = {2, 8, 11, 7};
        int target = 9;
        int[] result = twoSumNo1.twoSum(nums,target);
        System.out.println(Arrays.toString(result));
    }

}