package com.leetcode.demo.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/18 17:51
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GuardeObject<T> {

    T obj;
    final Lock lock = new ReentrantLock();
    final Condition done = lock.newCondition();

    final int timeout = 2;
    final static Map<Object, GuardeObject> gos = new ConcurrentHashMap<>();

    static <K> GuardeObject create(K key) {
        GuardeObject go = new GuardeObject();
        gos.put(key, go);
        return go;
    }

    static <K, T> void fireEvent(K key, T obj) {
        GuardeObject go = gos.remove(key);
        if (go != null) {
            go.onChanged(obj);
        }
    }

    T get(Predicate<T> p) {
        lock.lock();
        try {
            while (!p.test(obj)) {
                done.await(timeout, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return obj;
    }

    void onChanged(T obj) {
        lock.lock();
        try {
            this.obj = obj;
            done.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
