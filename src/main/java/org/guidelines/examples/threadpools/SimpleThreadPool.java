package org.guidelines.examples.threadpools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SimpleThreadPool {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(16, 20, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(50));
        threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName()));
        Runnable runnable = () -> {
            while (true) {
                System.out.println("Pool:" + threadPoolExecutor);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread info = new Thread(runnable);
        info.start();

        Thread.sleep(100);
        List<Future<?>> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<?> submit = threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            tasks.add(submit);
        }
        info.join();
    }
}
