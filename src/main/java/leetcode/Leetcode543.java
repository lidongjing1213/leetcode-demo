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
public class Leetcode543 {
    int depth;

    public int diameterOfBinaryTree(TreeNode root) {
        depth = 1;
        depth(root);
        return depth - 1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        depth = Math.max(depth, left + right + 1);
        return Math.max(left, right)+1;
    }
}
