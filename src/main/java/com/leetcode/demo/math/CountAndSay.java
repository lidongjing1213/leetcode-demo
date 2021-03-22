package com.leetcode.demo.math;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2020/12/28 10:19
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CountAndSay {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countAndSay(n));
    }

    private static String countAndSay(int n) {
        String s = "1";
        if (n == 1) {
            return s;
        } else {
            for (int i = 1; i < n; i++) {
                s = get(s);
            }
        }
        return s;
    }

    private static String get(String s) {
        if(s.length()==1){
            return "11";
        }
        String str="";
        int count = 1;
        int j=1;
        for (; j < s.length(); j++) {
            if (s.charAt(j) == s.charAt(j - 1)) {
                count++;
            } else {
                str = str + count + s.charAt(j - 1);
                count = 1;
            }
        }
        str = str + count + s.charAt(j - 1);
        return str;
    }


}
