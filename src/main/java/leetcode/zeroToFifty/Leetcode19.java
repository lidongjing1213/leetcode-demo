package leetcode.zeroToFifty;


import leetcode.ListNode;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 14:28
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode19 {
    public static void main(String[] args) {
        ListNode head=new ListNode(5);
        ListNode head1=new ListNode(4,head);
        ListNode head2=new ListNode(3,head1);
        ListNode head3=new ListNode(2,head2);
        ListNode head4=new ListNode(1,head3);
        removeNthFromEnd(head4,2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode dummy = new ListNode(0,head);
        ListNode q=dummy;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return dummy.next;
    }
}
