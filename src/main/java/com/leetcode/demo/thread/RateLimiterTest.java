package com.leetcode.demo.thread;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/19 14:18
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RateLimiterTest {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(2.0);
        ExecutorService es = Executors.newFixedThreadPool(1);
        final Long prev = System.nanoTime();

        for (int i = 0; i < 20; i++) {
            rateLimiter.acquire();

            es.execute(() -> {
                long cur = System.nanoTime();

                System.out.println((cur - prev) / 1000);
                prev = cur;
            });
        }
    }
}
