package com.leetcode.demo.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * @Date: 2020/12/23 10:33
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TwoSum {
    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = towSum(nums, target);
        System.out.println(result);


    }

    /**
     *算法思路：用hashmap存放数组中整数值以及下标
     *
     */
    private static int[] towSum(int[] nums, int target) {
        //使用hashMap存放该值以及对应的数据下标
        Map<Integer, Integer> hashMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{0};
    }
}
