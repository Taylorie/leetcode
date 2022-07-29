//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 5482 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) return s;
        int len = s.length();
        int begin = 0;
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((j - i + 1 > maxLen) || check(s, i, j)) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private boolean check(String s, int l, int r) {
        char[] array = s.toCharArray();
        while (l < r) {
            if (array[l] == array[r]) {
                ++l;
                --r;
                continue;
            }
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
