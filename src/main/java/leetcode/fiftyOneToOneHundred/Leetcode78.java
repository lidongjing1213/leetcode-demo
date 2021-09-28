package leetcode.fiftyOneToOneHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/27 9:27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode78 {

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0, new ArrayList<>());
        return result;
    }

    public  static void backtrack(List<List<Integer>> result, int[] nums, int cur, List<Integer> combine) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(combine));
            return;
        }
        combine.add(nums[cur]);
        backtrack(result, nums, cur + 1, combine);
        combine.remove(combine.size() - 1);
        backtrack(result, nums, cur + 1, combine);

    }
}
