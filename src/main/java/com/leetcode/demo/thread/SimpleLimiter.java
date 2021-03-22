package com.leetcode.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/19 16:17
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SimpleLimiter {
    //当前令牌桶的令牌数量
    long storedPermits = 0;
    //令牌桶的容量
    long maxPermits = 3;
    //下一个令牌产生的时间
    long next = System.nanoTime();
    //发放令牌的时间间隔
    long interval = 1000;

    //请求时间在下一令牌产生时间之后，则
    //1.重新计算令牌桶中的令牌数
    //2、将下一个令牌发放时间重置为当前时间
    void resync(long now) {
        if (now > next) {
            long nexPermits = (now - next) / interval;
            storedPermits = Math.min(maxPermits, storedPermits + nexPermits);
            next = now;
        }
    }

    //预占令牌，返回能够获取令牌的时间
    synchronized long reserve(long now) {
        resync(now);
        //能够获取令牌的时间
        long at = next;
        //令牌桶能够提供的令牌
        long fb = Math.min(1, storedPermits);
        //令牌净需求：首先减去令牌桶中的令牌
        long nr = 1 - fb;
        //重新计算下次令牌产生的时间
        next = next + nr * interval;
        this.storedPermits -= fb;
        return at;
    }

    //申请令牌
    void acquire() {
        //申请令牌的时间
        long now = System.nanoTime();
        //预占资源
        long at = reserve(now);
        long waitTime = Math.max(at - now, 0);
        //按照条件等待
        if (waitTime > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
