package leetcode.zeroToFifty;

import java.util.HashSet;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @author ldj
 * @Date: 2021/9/24 10:45
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        int left = 0;
        int right = -1;
        Set<Character> set = new HashSet<>();
        while (left < s.length()) {
            if ((right + 1 < s.length()) && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, (right + 1 - left));
        }
        return maxLen;
    }
}
