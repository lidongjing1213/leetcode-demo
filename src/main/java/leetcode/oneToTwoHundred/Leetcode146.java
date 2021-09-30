package leetcode.oneToTwoHundred;

import leetcode.LinkedNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/28 10:41
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Leetcode146 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);
    }

    public static class LRUCache {
        int capacity;
        int size;
        Map<Integer, LinkedNode> map = new HashMap<>();
        LinkedNode head;
        LinkedNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new LinkedNode();
            tail = new LinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                LinkedNode node = map.get(key);
                remove(node);
                addFirst(node);
                return node.value;
            }
            return -1;
        }


        public void put(int key, int value) {
            LinkedNode node = new LinkedNode(key, value);
            if (map.containsKey(key)) {
                node = map.get(key);
                remove(node);
            } else {
                if (size == capacity) {
                    LinkedNode lastNode = tail.prev;
                    remove(lastNode);
                    map.remove(lastNode.key);
                } else {
                    ++size;
                }
            }
            node.value = value;
            addFirst(node);
            map.put(key, node);
        }

        public void remove(LinkedNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        private void addFirst(LinkedNode node) {
          node.prev=head;
          node.next=head.next;
          head.next.prev=node;
          head.next=node;
        }
    }
}
