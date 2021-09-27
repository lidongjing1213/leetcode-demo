package leetcode.fiftyOneToOneHundred;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author ldj
 * @Date: 2021/9/24 15:13
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode53 {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}
