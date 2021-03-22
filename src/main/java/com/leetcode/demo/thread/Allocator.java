package com.leetcode.demo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/9 16:00
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Allocator {
    private List<Object> als = new ArrayList<>();

    synchronized void apply(Object to, Object from) {
        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        als.add(to);
        als.add(from);
    }

    synchronized void free(Object to, Object from) {
        als.remove(to);
        als.remove(from);
        notifyAll();
    }
}
