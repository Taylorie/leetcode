//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯 👍 891 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used, res, new ArrayList<Integer>(), 0);
        return res;
    }

    /**
     * 回溯
     *
     * @param nums  回溯数组
     * @param used  数组使用记录
     * @param res   结果集
     * @param list  字结果集
     * @param index 数组遍历起点
     */
    private void backtracking(int[] nums, boolean[] used, List<List<Integer>> res, ArrayList<Integer> list, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            backtracking(nums, used, res, list, i + 1);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
