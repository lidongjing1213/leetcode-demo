package leetcode.zeroToFifty;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 14:29
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(List<List<Integer>> result, int[] candidates, int target, int index, List<Integer> list) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        backtrack(result, candidates, target, index + 1, list);

        if (target - candidates[index] >= 0) {
            list.add(candidates[index]);
            backtrack(result, candidates, target - candidates[index], index, list);
            list.remove(list.size() - 1);
        }

    }
}
