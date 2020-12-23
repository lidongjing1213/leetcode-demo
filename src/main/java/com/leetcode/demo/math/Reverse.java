package com.leetcode.demo.math;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * @Date: 2020/12/23 10:57
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Reverse {
    public static void main(String[] args) {
        int x = 123;
        int ver = reverse(x);
        System.out.println(ver);

    }

    /**
     *算法思路：求余数反转
     */
    private static int reverse(int x) {
        int ver = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (ver > Integer.MAX_VALUE / 10 || (ver == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ver < Integer.MIN_VALUE / 10 || (ver == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ver = ver * 10 + pop;
        }
        return ver;
    }
}
