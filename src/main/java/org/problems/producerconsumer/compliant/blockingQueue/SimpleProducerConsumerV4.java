package org.problems.producerconsumer.compliant.blockingQueue;

import org.jcip.annotations.ThreadSafe;
import org.utils.ThreadUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class SimpleProducerConsumerV4 {

    private static final int MAX_QUEUE_CAPACITY = 5;
    private BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(MAX_QUEUE_CAPACITY);
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    private static final int MAX_VALUE = 20;

    private void produce() {
        while (true) {
            int data = atomicInteger.getAndIncrement();
            if (data > MAX_VALUE) break;
            try {
                blockingQueue.put(data);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            System.out.printf("[%s] Value produced: %d\n", Thread.currentThread().getName(), data);
        }
    }

    private void consume() {
        while (true) {
            int value;
            try {
                ThreadUtils.sleep(1000);
                value = blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            System.out.printf("[%s] Value consumed: %d\n", Thread.currentThread().getName(), value);
            if (value >= MAX_VALUE) break;
        }
    }


    private void runSingleProducerConsumer() throws InterruptedException {
        Thread producerThread = new Thread(this::produce, "Producer-1");
        producerThread.start();

        Thread consumerThread = new Thread(this::consume, "Consumer-1");
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleProducerConsumerV4 simpleProducerConsumer = new SimpleProducerConsumerV4();
        simpleProducerConsumer.runSingleProducerConsumer();
    }
}
