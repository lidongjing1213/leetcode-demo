package com.leetcode.demo.thread;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/10 15:28
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Point {



    public static void main(String[] args) throws InterruptedException {
        final StampedLock stampedLock=new StampedLock();

        Thread thread1=new Thread(()->{
            stampedLock.writeLock();

            LockSupport.park();;
        });

        thread1.start();

        Thread.sleep(100);

        Thread thread2=new Thread(()->{
            stampedLock.readLock();
        });

        thread2.start();

        Thread.sleep(100);

        thread2.interrupt();

        thread2.join();
    }
}
