package leetcode.oneToTwoHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 * 示例：
 * <p>
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 *
 * @author ldj
 * @Date: 2021/9/23 19:07
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode163 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3, 50, 75};
        List<String> result = findMissingRanges(nums, 0, 99);
        for (String str : result) {
            System.out.print(str + " ");
        }

    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if(nums==null || nums.length==0){
            if(upper==lower){
                result.add(String.valueOf(lower));
            }else{
                result.add(lower + "->" + upper);
            }
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if ((nums[i]-lower)>1) {
                    result.add(lower + "->" + (nums[i] - 1));
                }else if((nums[i]-lower)==1){
                    result.add(String.valueOf(lower));
                }
            } else {
                if ((nums[i] - nums[i - 1]) > 2) {
                    result.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
                } else if ((nums[i] - nums[i - 1]) == 2) {
                    result.add(String.valueOf(nums[i - 1] + 1));
                }
            }
        }
        if ((upper - nums[nums.length - 1])>1) {
            result.add((nums[nums.length - 1] + 1) + "->" + upper);
        }else if((upper - nums[nums.length - 1])==1){
            result.add(String.valueOf(upper));
        }
        return result;
    }
}
