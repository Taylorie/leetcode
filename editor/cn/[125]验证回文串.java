//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 550 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        char[] array = s.toCharArray();
        while (l <= r) {
            if (!Character.isLetterOrDigit(array[l])) {
                ++l;
                continue;
            }
            if (!Character.isLetterOrDigit(array[r])) {
                --r;
                continue;
            }
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
