package leetcode;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author ldj
 * @Date: 2021/9/24 10:02
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode2 {

    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        addTwoNumbers(l1,l2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode();
        ListNode currentNode = newList;
        int n = 0;
        while (l1 != null || l2 != null) {
            int val = n;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(val % 10);
            n = val / 10;
            currentNode.next = newNode;
            currentNode = currentNode.next;
        }
        if (n != 0) {
            ListNode newNode = new ListNode(n);
            currentNode.next = newNode;
        }
        return newList.next;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }


        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
