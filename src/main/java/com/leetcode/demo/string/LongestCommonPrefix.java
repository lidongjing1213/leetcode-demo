package com.leetcode.demo.string;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @Date: 2020/12/24 10:30
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));


    }

    private static String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }

        //寻找最小字符串的长度
        int minStrLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minStrLength = Math.min(minStrLength, str.length());
        }
        //二分查找
        int low = 0, high = minStrLength;

        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    private static boolean isCommonPrefix(String[] strs, int mid) {
        String subStr = strs[0].substring(0, mid);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String string = strs[i];
            for (int j = 0; j < mid; j++) {
                if (string.charAt(j) != subStr.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
