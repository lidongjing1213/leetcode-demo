package com.leetcode.demo.math;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * @Date: 2020/12/24 10:02
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RomanToInt {

    public static void main(String[] args) {
        String str = "III";
        int ret = romanToInt(str);
        System.out.println(ret);

    }

    private static int romanToInt(String s) {
        if(null==s || s.length()==0){
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>(7);
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int ret = 0;
        int pre = hashMap.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int after = hashMap.get(s.charAt(i));
            if (pre < after) {
                ret -=  pre;
            } else {
                ret +=pre;
            }
            pre = after;
        }
        ret += pre;
        return ret;
    }
}
