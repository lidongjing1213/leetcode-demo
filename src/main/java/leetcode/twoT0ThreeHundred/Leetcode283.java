package leetcode.twoT0ThreeHundred;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 10:34
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode283 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (left != right) {
                    nums[left] = nums[i];
                }
                left++;
            }
            right++;
        }
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
