package org.problems.producerconsumer.compliant.blockingQueue;

import org.utils.ThreadUtils;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {

        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String element = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + " consumed " + element);
            } catch (InterruptedException e) {
                System.out.println("Consumer " + Thread.currentThread().getName() + " was interrupted");
            }
            ThreadUtils.randomSleep(1000);
        }
    }
}
