//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 1723 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //扩展
        List<List<Integer>> res = new ArrayList<>();
//        res.add(new ArrayList<>());
//
//        for (int num : nums) {
//            List<List<Integer>> temp = new ArrayList<>();
//
//            for (List<Integer> resList : res) {
//                List<Integer> resTemp = new ArrayList<>(resList);
//                resTemp.add(num);
//                temp.add(resTemp);
//            }
//            res.addAll(temp);
//        }
//        return res;

        //回溯
//        for (int i = 0; i < nums.length; i++) {
//            backtracking(nums, res, i + 1, 0, new ArrayList<Integer>());
//        }

        //DFS

        dfs(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> list, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    private void backtracking(int[] nums, List<List<Integer>> res, int len, int index, ArrayList<Integer> list) {
        if (list.size() == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(nums, res, len, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
