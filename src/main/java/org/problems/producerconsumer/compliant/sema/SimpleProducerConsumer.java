package org.problems.producerconsumer.compliant.sema;


public class SimpleProducerConsumer {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        int maxSize = 10;

        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);

        Thread producerThread = new Thread(producer, "Producer-1");
        Thread consumerThread1 = new Thread(consumer1, "Consumer-1");
        Thread consumerThread2 = new Thread(consumer2, "Consumer-2");

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();

    }
}
