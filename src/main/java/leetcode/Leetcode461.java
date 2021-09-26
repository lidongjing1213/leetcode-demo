package leetcode;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 10:35
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode461 {

    public int hammingDistance(int x, int y) {
        int z=x^y;
        int ret=0;
        while (z!=0){
            z&=(z-1);
            ret++;
        }
        return ret;

    }
}
