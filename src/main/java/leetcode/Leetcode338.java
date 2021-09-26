package leetcode;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 10:34
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode338 {

    public int[] countBits(int n) {

        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int ones = 0;
            int j = i;
            while (j > 0) {
                j &= (j - 1);
                ones++;
            }
            result[i] = ones;
        }
        return result;
    }
}
