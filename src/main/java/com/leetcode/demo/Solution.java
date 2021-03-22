package com.leetcode.demo;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/1/4 17:09
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(pivotIndex(nums));

    }

    private static int pivotIndex(int[] nums) {
        if (0==nums.length) {
            return -1;
        }
        int index = nums.length / 2;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < index; i++) {
            sum1 = nums[i] + sum1;
            if (i + index + 1 < nums.length) {
                sum2 = nums[i + index + 1] + sum2;
            }
        }
        if (sum1 == sum2) {
            return index;
        }
        return -1;
    }


}
