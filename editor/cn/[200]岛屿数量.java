//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1825 👎 0


import jdk.nashorn.api.tree.ReturnTree;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == '1') {
                    ++result;
                    dfs(grid, result, row, col, x, y);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int result, int row, int col, int x, int y) {
        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, result, row, col, x + 1, y);
        dfs(grid, result, row, col, x - 1, y);
        dfs(grid, result, row, col, x, y + 1);
        dfs(grid, result, row, col, x, y - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
