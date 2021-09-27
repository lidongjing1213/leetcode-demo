package leetcode.twoT0ThreeHundred;

import leetcode.ListNode;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 10:16
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode234 {

    public boolean isPalindrome(ListNode head) {
        //第一步 用快慢指针找到链表前半部分的尾节点
        ListNode firstHalfEnd = endOfFirstHalf(head);

        //第二步 翻转后半部分链表
        ListNode sendHalfStart = reverse(firstHalfEnd.next);
        //第三步  判断是否是回文
        ListNode left = head;
        ListNode right = sendHalfStart;
        boolean result = true;
        while (result && right != null) {
            if (left.val != right.val) {
                result = false;
            }
            left = left.next;
            right = right.next;
        }
        //第四步  还原链表
        firstHalfEnd.next = reverse(sendHalfStart);
        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode p = head;
        ListNode newHead = new ListNode();
        while (p != null) {
            ListNode node = p;
            p = p.next;
            node.next = newHead.next;
            newHead.next = node;
        }
        return newHead.next;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
