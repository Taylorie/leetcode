//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 602 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//import doc.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) return res;
        dfs(root, res, 0);
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            ArrayList<Integer> list = new ArrayList<>();
//            while (size > 0) {
//                TreeNode node = queue.poll();
//                list.add(node.val);
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//                --size;
//            }
//            res.addFirst(new ArrayList<>(list));
//        }
//        Collections.reverse(res);
        return res;
    }

    private void dfs(TreeNode root, LinkedList<List<Integer>> res, int index) {
        if (root == null) return;
        if (res.size() - 1 < index) res.addFirst(new ArrayList<>());
//        res.get(index).add(root.val);
        res.get(res.size() - index - 1).add(root.val);
        dfs(root.left, res, index + 1);
        dfs(root.right, res, index + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
