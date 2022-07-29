//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 1504 👎 0


import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];

        return getMajority(nums, 0, nums.length - 1);
    }

    private int getMajority(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = (r - l) / 2 + l;
        int leftMajor = getMajority(nums, l, mid);
        int rightMajor = getMajority(nums, mid + 1, r);
        if (leftMajor == rightMajor) {
            return leftMajor;
        }
        int leftCount = 0, rightCount = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] == leftMajor) {
                leftCount++;
            } else if (nums[i] == rightMajor) {
                rightCount++;
            }
        }
        return leftCount > rightCount ? leftMajor : rightMajor;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
