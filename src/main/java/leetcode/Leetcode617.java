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
public class Leetcode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 != null && root2 != null) {
            TreeNode newNode = new TreeNode(root1.val + root2.val);
            newNode.left = mergeTrees(root1.left, root2.left);
            newNode.right = mergeTrees(root1.right, root2.right);
            return newNode;
        } else if (root1 != null) {
            return root1;
        } else {
            return root2;
        }

    }
}
