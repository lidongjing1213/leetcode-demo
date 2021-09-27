package leetcode.zeroToFifty;

import leetcode.ListNode;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author ldj
 * @Date: 2021/9/24 15:03
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode21 {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = l1;
        ListNode q = l2;
        ListNode currentNode = head;
        while (p != null && q != null) {
            ListNode r;
            if (p.val <= q.val) {
                r = p;
                p = p.next;
            } else {
                r = q;
                q = q.next;
            }
            r.next = null;
            currentNode.next = r;
            currentNode = currentNode.next;
        }
        if (p != null) {
            currentNode.next = p;
        }
        if (q != null) {
            currentNode.next = q;
        }
        return head.next;

    }
}
