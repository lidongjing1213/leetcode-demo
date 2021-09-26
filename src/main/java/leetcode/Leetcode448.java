package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 10:34
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            int x = (num - 1) % len;
            nums[x] += len;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                result.add(i + 1);
            }
        }
        return result;


    }
}
