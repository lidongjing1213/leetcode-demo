package leetcode.fiftyOneToOneHundred;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/27 9:26
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode55 {

    public boolean canJump(int[] nums) {
        int n=nums.length;
        int rightmost=0;
        for(int i=0;i<n;i++){
            if(i<=rightmost){
                rightmost = Math.max(i+nums[i],rightmost);
                if(rightmost>=n-1){
                    return true;
                }
            }
        }
        return false;

    }
}
