package org.guidelines.examples.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadStateExample2 implements Runnable {


    private CountDownLatch countDownLatch;

    public ThreadStateExample2(CountDownLatch countDownLatch) {

        this.countDownLatch = countDownLatch;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(new ThreadStateExample2(countDownLatch), "Thread-" + i));
        }

        for (Thread thread : threads) {
            //executorService.submit(thread);
            thread.start();
        }

        ReportingThread reportingThread = new ReportingThread(threads);
        reportingThread.start();

        countDownLatch.await();
//        executorService.shutdown();
        reportingThread.stopReporting();
        System.out.println("Done");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Executed: " + Thread.currentThread().getName());
        countDownLatch.countDown();
    }
}
