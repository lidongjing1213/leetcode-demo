package leetcode;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 9:35
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode169 {
    public static void main(String[] args) {
        int[] nums=new int[]{3,3,4};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        //投票法
        int count = 0;
        int candidate = 0;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }
            count = candidate == i ? ++count : --count;
        }
        return candidate;
    }
}
