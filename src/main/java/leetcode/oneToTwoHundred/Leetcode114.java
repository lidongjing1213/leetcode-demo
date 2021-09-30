package leetcode.oneToTwoHundred;

import leetcode.TreeNode;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/28 10:40
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode114 {

    public void flatten(TreeNode root) {
        TreeNode cur=root;
        while (cur!=null){
            if(cur.left!=null){
                TreeNode next=cur.left;
                TreeNode pred=next;
                while (pred.right!=null){
                    pred=pred.right;
                }
                pred.right=cur.right;
                cur.left=null;
                cur.right=next;
            }
            cur=cur.right;
        }
    }
}
