//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 1115 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //边界判定
        if (nums == null || nums.length < 1) {
            return ans;
        }
        //数组排序是为了后面进行回溯判断是否需要剪枝的必要条件
        Arrays.sort(nums);
        //哈希模拟
        boolean[] map = new boolean[nums.length];
        backtracking(nums, ans, map, new ArrayList<Integer>(), nums.length);
        return ans;
    }

    /**
     * 回溯
     * @param nums 遍历数组
     * @param ans 结果集
     * @param map 使用记录数组
     * @param list 子结果
     * @param length 数组长度
     */
    private void backtracking(int[] nums, List<List<Integer>> ans, boolean[] map, ArrayList<Integer> list, int length) {
        //如果子集合长度和数组长度一致就加入结果集
        if (list.size() == length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map[i]) {
                //如果当前不是数组的第一个元素,并且和上一个元素相同
                //并且上一个元素没有被使用过
                if (i > 0 && nums[i] == nums[i - 1] && !map[i - 1]) {
                    continue;
                }
                map[i] = true;
                list.add(nums[i]);
                backtracking(nums, ans, map, list, length);
                list.remove(list.size() - 1);
                map[i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
