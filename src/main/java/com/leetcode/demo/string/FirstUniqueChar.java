package com.leetcode.demo.string;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1〉
 *
 * @Date: 2020/12/23 10:02
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FirstUniqueChar {

    public static void main(String[] args) {

        String s = "loveleetcode";
        int index = firstUniqChar(s);
        System.out.println(index);

    }

    /**
     *算法思路：首先循环遍历一次，用hashmap存放每个字符以及其出现的次数
     * 再一次循环遍历，找到map中第一个value为1的值
     * 时间复杂度O(n)
     * 空间复杂度：O(∣Σ∣)
     */
    private static int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            //存放字符以及其出现的次数
            char c = s.charAt(i);
            Integer count = hashMap.get(c);
            if (null == count) {
                count = 0;
            }
            hashMap.put(c, count + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


}
