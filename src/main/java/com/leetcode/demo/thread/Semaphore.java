package com.leetcode.demo.thread;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/10 11:36
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Semaphore {
    int count;

    Queue queue;

    Semaphore(int count) {
        this.count = count;
    }

    void down(){
        this.count--;
        if(this.count<0){
            //将当前线程插入等待队列
            queue.add(this);
        }
    }

    void  up(){
        this.count++;
        if(this.count<=0){
            queue.remove();
        }
    }


}
