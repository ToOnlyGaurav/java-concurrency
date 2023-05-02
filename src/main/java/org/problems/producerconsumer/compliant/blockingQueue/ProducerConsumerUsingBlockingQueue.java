package org.problems.producerconsumer.compliant.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        Producer producer = new Producer(blockingQueue);
        Consumer consumer1 = new Consumer(blockingQueue);
        Consumer consumer2 = new Consumer(blockingQueue);

        Thread producerThread = new Thread(producer, "Producer-1");
        Thread consumerThread1 = new Thread(consumer1, "Consumer-1");
        Thread consumerThread2 = new Thread(consumer2, "Consumer-2");

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}
