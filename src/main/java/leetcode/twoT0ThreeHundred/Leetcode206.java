package leetcode.twoT0ThreeHundred;

import leetcode.ListNode;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/26 9:54
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode p = head;
        while (p != null) {
            ListNode currentNode = p;
            p = p.next;
            currentNode.next = newHead.next;
            newHead.next = currentNode;
        }
        return newHead.next;

    }
}
