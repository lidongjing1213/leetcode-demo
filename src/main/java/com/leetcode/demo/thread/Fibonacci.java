package com.leetcode.demo.thread;

import java.util.concurrent.RecursiveTask;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/12 11:24
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Fibonacci extends RecursiveTask<Integer> {
    final int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if(n<=1){
            return n;
        }
        Fibonacci f1=new Fibonacci(n-1);
        f1.fork();
        Fibonacci f2=new Fibonacci(n-2);
        return f2.compute()+f1.join();
    }
}
