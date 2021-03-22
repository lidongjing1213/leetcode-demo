package com.leetcode.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/12 9:48
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class T1Task implements Callable<String> {

    FutureTask<String> ft2;

    public T1Task(FutureTask<String> ft2) {
        this.ft2 = ft2;
    }


    @Override
    public String call() throws Exception {
        System.out.println("T1:洗水壶。。。");

        TimeUnit.SECONDS.sleep(1);

        System.out.println("T1:烧开水。。。");
        TimeUnit.SECONDS.sleep(15);

     String tf=ft2.get();

        System.out.println("T1:拿到茶叶："+tf);

        System.out.println("T1:泡茶。。。");
        return "上茶："+tf;
    }
}
