package com.leetcode.demo.thread;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2020/12/25 9:09
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Condition2 implements Runnable {
    static Condition2 condition1 = new Condition2();

    static Condition2 condition2 = new Condition2();

    @Override
    public void run() {
        method();
    }

    private static synchronized void method() {
        System.out.println("线程名：" + Thread.currentThread().getName() + ",运行开始");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名：" + Thread.currentThread().getName() + ",运行结束");
    }

    public static void main(String[] args) {
        Thread thread1=new Thread(condition1);
        Thread thread2=new Thread(condition2);
        thread1.start();
        thread2.start();
    }
}
