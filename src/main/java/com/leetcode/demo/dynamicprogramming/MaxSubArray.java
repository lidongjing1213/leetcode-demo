package com.leetcode.demo.dynamicprogramming;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2020/12/28 11:21
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MaxSubArray {


        public int lsum, rsum, msum, isum;

        public MaxSubArray(int lsum, int rsum, int msum, int isum) {
            this.lsum = lsum;
            this.rsum = rsum;
            this.msum = msum;
            this.isum = isum;
        }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(maxSunArray(nums));
    }

    public static int maxSunArray(int[] nums) {

        return get(nums, 0, nums.length - 1).msum;
    }

    public static MaxSubArray get(int[] nums, int l, int r) {
        if (l == r) {
            return new MaxSubArray(nums[1], nums[1], nums[1], nums[1]);
        }
        int m = (l + r) >> 1;
        MaxSubArray lSub = get(nums, l, m);
        MaxSubArray rSub = get(nums, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public static MaxSubArray pushUp(MaxSubArray lSub, MaxSubArray rSub) {
        int isum = lSub.isum + rSub.isum;
        int lsum = Math.max(lSub.lsum, lSub.isum + rSub.lsum);
        int rsum = Math.max(rSub.rsum, rSub.isum + lSub.rsum);
        int msum = Math.max(Math.max(lSub.msum, rSub.msum), lSub.rsum + rSub.lsum);
        return new MaxSubArray(lsum, rsum, msum, isum);

    }


}
