package leetcode.zeroToFifty;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 14:28
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode31 {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        if (index > 0) {
            int temp = nums[index];
            nums[index] = nums[index - 1];
            nums[index - 1] = temp;
        }else{
            Arrays.sort(nums);
        }

    }
}
