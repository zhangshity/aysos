//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。 
//
// 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。 
//
// 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并
//的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//解释：需要合并 [1,2,3] 和 [2,5,6] 。
//合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//解释：需要合并 [1] 和 [] 。
//合并结果是 [1] 。
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0], m = 0, nums2 = [1], n = 1
//输出：[1]
//解释：需要合并的数组是 [] 和 [1] 。
//合并结果是 [1] 。
//注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -10⁹ <= nums1[i], nums2[j] <= 10⁹ 
// 
//
// 
//
// 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？ 
//
// Related Topics 数组 双指针 排序 👍 2325 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

//        // 初始化容器数组
//        int[] result = new int[m + n];
//
//        // 遍历数组1，同时比较数组2，将较小的元素放入容器数组
//        for (int i = 0; i < nums1.length; i++) {
//            if (nums1[i] != 0) {
//
//                for (int j = 0; j < nums2.length; j++) {
//                        if (nums1[i] <= nums2[j]) {
//                            result[i] = nums1[i];
//                            continue;
//                        } else if (nums1[i] > nums2[j]) {
//                            result[i] = nums2[j];
//                            continue;
//                        }
//                }
//
//            }
//        }


        // 方法1：双指针比较（双下标）
        // 初始化结果数组
        int[] result = new int[m + n];
        int pr = 0;
        int p1 = 0;
        int p2 = 0;

        // 双指针移动比较，直到某个数组比较完成
        while ((p1 < m) && (p2 < n)) {
            if (nums1[p1] <= nums2[p2]) {
                result[pr] = nums1[p1];
                p1++; // 用了数组1的，数组1指针后移
            } else {
                result[pr] = nums2[p2];
                p2++; // 用了数组2的，数组2指针后移
            }

            pr++; // 结果指针后移
        }

        // 剩余的数组 直接赋值
        while (p1 < m) {
            result[pr] = nums1[p1];
            p1++;
            pr++;
        }
        while (p2 < n) {
            result[pr] = nums2[p2];
            p2++;
            pr++;
        }


        // 结果数据 赋值给 数组1
        for (int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }


//        // 初始化结果数组
//        int[] nums1Cp = new int[m];
//        int p1 = 0;
//        int pcp = 0;
//        int p2 = 0;
//
//        while ((pcp < m) && (p2 < n)) {
//
//            if (nums1Cp[pcp] <= nums2[p2]) {
//                nums1[p1] = nums1Cp[pcp];
//                pcp++;
//            } else {
//                nums1[p1] = nums2[p2];
//                p2++;
//            }
//            p1++; // 结果指针后移
//        }


        // 方法2：利用api
//        System.arraycopy(nums2, 0, nums1, m, n);
//        Arrays.sort(nums1);

    }
}

//leetcode submit region end(Prohibit modification and deletion)
