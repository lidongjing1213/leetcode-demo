package leetcode;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 9:28
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode160 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        while (p!=q){
            p=p==null?headB:p.next;
            q=q==null?headA:q.next;
        }
        return p;
    }
}
