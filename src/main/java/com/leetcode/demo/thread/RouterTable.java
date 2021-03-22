package com.leetcode.demo.thread;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/18 15:53
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RouterTable {
    ConcurrentHashMap<String, CopyOnWriteArraySet<Router>> rt = new ConcurrentHashMap<>();

    public Set<Router> get(String iface) {
        return rt.get(iface);
    }

    public void remove(Router router) {
        Set<Router> set = rt.get(router.getIface());
        if (set != null) {
            set.remove(router);
        }
    }

    public void add(Router router) {
        Set<Router> set = rt.computeIfAbsent(router.getIface(), r -> new CopyOnWriteArraySet<>());
        set.add(router);
    }
}
