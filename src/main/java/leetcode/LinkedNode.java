package leetcode;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/9/28 11:09
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LinkedNode {
    public int key;
    public int value;
    public LinkedNode prev;
    public LinkedNode next;

    public LinkedNode(){

    }

    public LinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
