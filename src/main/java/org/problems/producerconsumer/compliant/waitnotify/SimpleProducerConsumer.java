package org.problems.producerconsumer.compliant.waitnotify;


import java.util.LinkedList;
import java.util.Queue;

public class SimpleProducerConsumer {
    public static void main(String[] args) {
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 10;

        Producer producer = new Producer(buffer, maxSize);
        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);

        Thread producerThread = new Thread(producer, "Producer-1");
        Thread consumerThread1 = new Thread(consumer1, "Consumer-1");
        Thread consumerThread2 = new Thread(consumer2, "Consumer-2");

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();

    }
}
