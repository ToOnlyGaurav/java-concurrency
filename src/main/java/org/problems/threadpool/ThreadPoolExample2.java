package org.problems.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample2 {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10));
        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ": Task " + taskNo);
            });
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(2, TimeUnit.SECONDS);
    }
}
