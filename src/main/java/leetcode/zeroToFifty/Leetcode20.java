package leetcode.zeroToFifty;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author ldj
 * @Date: 2021/9/24 14:31
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode20 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty() || stack.peek() != map.get(s.charAt(i))) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }

}
