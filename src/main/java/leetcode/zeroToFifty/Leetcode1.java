package leetcode.zeroToFifty;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/24 9:23
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode1 {
    /**
     * 两数之和
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出和为目标值 target的那两个整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     * 示例 1：
     * <p>
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     */

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = twoSum(nums, 9);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer>  map=new HashMap<>(nums.length-1);
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                  return new int[]{i,map.get(target-nums[i])};
            }else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
