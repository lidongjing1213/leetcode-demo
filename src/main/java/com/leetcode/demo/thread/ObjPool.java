package com.leetcode.demo.thread;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/10 14:44
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ObjPool<T, R> {
    List<T> pool;

    Semaphore semaphore;

    ObjPool(int size, T t) {
        pool = new Vector<T>() {
        };
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        semaphore = new Semaphore(size);
    }


    R exec(Function<T, R> function) throws InterruptedException {
        T t = null;
        semaphore.acquire();
        try {
            t=pool.remove(0);
            return function.apply(t);
        } finally {
            pool.add(t);
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ObjPool<Long,String> pool=new ObjPool<Long,String>(10,2L);
        pool.exec(t->{
            System.out.println(t);
            return t.toString();
        });
    }



}
