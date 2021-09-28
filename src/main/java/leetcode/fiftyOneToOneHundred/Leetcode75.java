package leetcode.fiftyOneToOneHundred;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/27 9:27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode75 {

    public void sortColors(int[] nums) {
        int zero=0;
        int one=0;
        int two=0;
        for(int num:nums){
            if(num==0){
                zero++;
            }else if(num==1){
                one++;
            }else{
                two++;
            }
        }
        int i=0;
        i = reset(nums, zero, i, 0);
        i = reset(nums, one, i, 1);
        i = reset(nums, two, i, 2);
    }

    private int reset(int[] nums, int zero, int i, int i2) {
        for (int j = 0; j < zero; j++) {
            nums[i++] = i2;
        }
        return i;
    }
}
