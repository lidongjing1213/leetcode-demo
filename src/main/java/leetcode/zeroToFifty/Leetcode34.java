package leetcode.zeroToFifty;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 14:28
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode34 {
    public static void main(String[] args) {
        int[] nums = new int[]{8};
        searchRange(nums, 8);
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                int l1 = mid;
                int r1 = mid;
                while (l1 >= 0 && nums[l1] == target) {
                    l1--;
                }
                while (r1 < n && nums[r1] == target) {
                    r1++;
                }
                return new int[]{l1 + 1, r1 - 1};
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return new int[]{-1, -1};

    }
}
