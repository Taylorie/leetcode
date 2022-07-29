//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1065 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(n, k, res, new ArrayList<Integer>(), 1);
        return res;
    }

    private void backtracking(int n, int k, List<List<Integer>> res, ArrayList<Integer> list, int index) {
//        if (list.size() == 0 && index > n - k+1) {
//            return;
//        }
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i<=n-(k-list.size())+1; i++) {
            list.add(i);
            backtracking(n, k, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
