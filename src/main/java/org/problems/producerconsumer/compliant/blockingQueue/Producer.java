package org.problems.producerconsumer.compliant.blockingQueue;

import org.utils.ThreadUtils;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {

        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            long timeMillis = System.currentTimeMillis();
            try {
                blockingQueue.put("" + timeMillis);
                System.out.println(Thread.currentThread().getName() + " produced " + timeMillis);
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
            ThreadUtils.randomSleep(1000);
        }
    }
}
