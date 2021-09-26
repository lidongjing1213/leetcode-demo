package leetcode;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 9:58
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode226 {

    public TreeNode invertTree(TreeNode root) {
       if(root==null){
           return null;
       }
       TreeNode left=invertTree(root.left);
       TreeNode right=invertTree(root.right);
       root.left=right;
       root.right=left;
       return root;
    }

}
