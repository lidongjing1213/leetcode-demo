package com.leetcode.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/12 9:52
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class T2Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("T2:洗茶壶。。。");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("T2:洗茶杯。。。");
        TimeUnit.SECONDS.sleep(2);

        System.out.println("T2:拿茶叶。。。");
        TimeUnit.SECONDS.sleep(1);
        return "龙井";
    }
}
