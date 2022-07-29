//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2028 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        HashMap<Character, String> map = new HashMap<>(8) {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        if (digits.length() == 1) {
            String s = map.get(digits.charAt(0));
            for (char c : s.toCharArray()) {
                res.add(String.valueOf(c));
            }
            return res;
        }
        int len = digits.length();
        backtracking(len, res, new StringBuilder(), map, digits.toCharArray(), 0);
        return res;
    }

    private void backtracking(int len, List<String> res, StringBuilder str, HashMap<Character, String> map, char[] letter, int index) {
        if (str.length() == len) {
            res.add(str.toString());
        } else {
            char digits = letter[index];
            String letters = map.get(digits);
            for (int i = 0; i < letters.length(); i++) {
                str.append(letters.charAt(i));
                backtracking(len, res, str, map, letter, index + 1);
                str.deleteCharAt(index);
            }
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
