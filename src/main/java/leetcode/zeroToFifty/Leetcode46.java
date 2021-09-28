package leetcode.zeroToFifty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/27 9:25
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine=new ArrayList<>();
        for(int num:nums){
            combine.add(num);
        }
        backtrack(result, nums, 0, combine);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, int[] nums, int index, List<Integer> combine) {
        if (index == nums.length) {
            result.add(new ArrayList<>(combine));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            Collections.swap(combine, index, i);
            backtrack(result, nums, index + 1, combine);
            Collections.swap(combine, index, i);
        }

    }
}
