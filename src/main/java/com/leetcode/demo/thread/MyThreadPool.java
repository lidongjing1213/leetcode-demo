package com.leetcode.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;


/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/10 19:34
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MyThreadPool {
    BlockingQueue<Runnable> workQueue;

    List<WorkerThread> threads = new ArrayList<>();

    MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;

        for (int idx = 0; idx < poolSize; idx++) {
            WorkerThread work = new WorkerThread();

            work.start();

            threads.add(work);
        }
    }

    class WorkerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable runnable = null;
                try {
                    runnable = workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runnable.run();
            }
        }
    }

}
