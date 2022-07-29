//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2126 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            ans.add(list);
            return ans;
        }
        boolean[] map = new boolean[nums.length];
        backtracking(nums, map, ans, new ArrayList<Integer>());
        return ans;
    }

    private void backtracking(int[] nums, boolean[] map, List<List<Integer>> ans, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map[i]) {
                map[i] = true;
                list.add(nums[i]);
                backtracking(nums, map, ans, list);
                list.remove(list.size() - 1);
                map[i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
