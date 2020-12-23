package com.leetcode.demo.math;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * @Date: 2020/12/23 11:20
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Palindrome {
    public static void main(String[] args) {
        int x = 11211;
        boolean result = isPalindrome(x);
        System.out.println(result);
    }

    /**
     *算法思路：判断是不是回文数，去掉边界条件负数以及个位数是0则不是回文数
     * 其次只需要将原数值反转一般，然后对比反转的数据和原数据是否相等即可
     */
    private static boolean isPalindrome(int x) {
        //负数 或者个位数是0则不是回文数
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }
        int ver = 0;
        //当反转数大于或者等于原数据值则停止 ，只反转一半
        while (ver < x) {
            ver = ver * 10 + x % 10;
            x /= 10;
        }
        //原数据值可能是奇数长度，中位数不考虑
        return ver == x || x == ver / 10;
    }
}
