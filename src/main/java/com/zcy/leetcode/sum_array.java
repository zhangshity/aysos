package com.zcy.leetcode;
/**
 * @ Author: chunyang.zhang
 * @ Description: leetcode算法题
 * @ Date: Created in 11:11 2018/11/9
 * @ Modified: By:
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class sum_array {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result;
            for(i=0;i<nums.length;i++){
                for(j=i+1;j<nums.length;j++){
                    if(nums[i] +nums[j] =target){
                        result = {i,j};
                        return result;
                    }
                }
            }

        }
    }
}
