package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/23 19:45
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode170 {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {

    }


    public static void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int complement = value - entry.getKey();
            if (complement != entry.getKey()) {
                if (map.containsKey(complement)) {
                    return true;
                }
            } else {
                if (map.get(complement) > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
