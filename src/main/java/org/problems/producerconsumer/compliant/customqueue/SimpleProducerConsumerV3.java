package org.problems.producerconsumer.compliant.customqueue;

import org.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class SimpleProducerConsumerV3 {

    private static final int MAX_QUEUE_CAPACITY = 5;

    private static final int MAX_VALUE = 20;
    private DataQueue<Integer> blockingQueue = new DataQueue<>(MAX_QUEUE_CAPACITY);
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    private void runSingleProducerConsumer() throws InterruptedException {
        Producer<Integer> producer = new Producer<>(blockingQueue);
        Thread producerThread = new Thread(producer, "Producer-1");
        producerThread.start();

        Consumer<Integer> consumer = new Consumer<>(blockingQueue);
        Thread consumerThread = new Thread(new Consumer<>(blockingQueue), "Consumer-1");
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        producer.stop();
        consumer.stop();
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleProducerConsumerV3 simpleProducerConsumer = new SimpleProducerConsumerV3();
        //simpleProducerConsumer.runSingleProducerConsumer();
        simpleProducerConsumer.runMultiProducerConsumer(1);
    }

    private void runMultiProducerConsumer(int count) {
        List<Thread> producers = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            producers.add(new Thread(new Producer<>(blockingQueue), "Producer-" + i));
        }

        List<Thread> consumers = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            consumers.add(new Thread(new Consumer<>(blockingQueue), "Consumer-" + i));
        }

        producers.forEach(Thread::start);
        consumers.forEach(Thread::start);


        producers.forEach(Thread::stop);
        consumers.forEach(Thread::stop);


    }
}
