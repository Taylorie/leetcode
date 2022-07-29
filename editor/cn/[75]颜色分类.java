//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库的sort函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 👍 1330 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        //边界判定 , 数组为空 , 或则数组长度小于 2 直接返回无需进行额外的排序操作
        if (nums == null || nums.length < 2) {
            return;
        }
        //定义两个指针 用作标记数字 0 和 2
        int l = 0, r = nums.length - 1;
        int i = 0;
        while (i <= r) {
            //当前遍历的数字为 0 则进行交换 并将两个指针前进一位
            if (nums[i] == 0) {
                swap(nums, i++, l++);
                //如果为 2 ,则交换到数组尾部 , 且因为不知道尾部数字是多少所以 i 指针不动
            } else if (nums[i] == 2) {
                swap(nums, i, r--);
            } else {
                ++i;
            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
