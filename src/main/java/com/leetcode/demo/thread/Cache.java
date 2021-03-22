package com.leetcode.demo.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/10 15:08
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Cache<K, V> {
    final Map<K, V> map = new HashMap<>();

    final ReadWriteLock rwl = new ReentrantReadWriteLock();

    final Lock readLock = rwl.readLock();

    final Lock writeLock = rwl.writeLock();

    final StampedLock stampedLock = new StampedLock();

    V get(K k) {
        V v = null;
        readLock.lock();
        try {
            v = map.get(k);
        } finally {
            readLock.unlock();
        }
        if (v != null) {

            return v;
        }

        writeLock.lock();
        try {
            //再次验证
            //其它线程可能已经查询过数据库
            v = map.get(k);
            if (v == null) {
                //查询数据库
                map.put(k, v);
            }
        } finally {
            writeLock.unlock();
        }
        return v;
    }

    void put(K key, V value) {
        writeLock.lock();

        try {
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        Cache<String, Object> cache = new Cache<>();
        long stamp = cache.stampedLock.writeLock();
        try {
        } finally {
            cache.stampedLock.unlockWrite(stamp);
        }
    }
}
