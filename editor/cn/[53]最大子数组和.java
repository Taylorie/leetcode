//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 5154 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //分治
        if (nums.length < 2) {
            return nums[0];
        }
        return getMax(nums, 0, nums.length - 1);
    }

    private int getMax(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int m = (r - l) / 2 + l;
        int leftSum = getMax(nums, l, m);
        int rightSum = getMax(nums, m + 1, r);
        int crossSum = getCrossSum(nums, l, r, m);
        return Math.max(leftSum, Math.max(rightSum, crossSum));
    }

    private int getCrossSum(int[] nums, int l, int r, int m) {
        int leftSum = nums[m], rightSum = nums[m + 1];
        int resLeftSum = leftSum, resRightSum = rightSum;
        for (int i = m - 1; i >= l; i--) {
            leftSum += nums[i];
            resLeftSum = Math.max(resLeftSum, leftSum);
        }
        for (int i = m + 2; i <= r; i++) {
            rightSum += nums[i];
            resRightSum = Math.max(resRightSum, rightSum);
        }
        return resLeftSum + resRightSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
