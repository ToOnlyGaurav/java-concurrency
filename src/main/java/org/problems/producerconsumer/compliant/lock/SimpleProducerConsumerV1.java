package org.problems.producerconsumer.compliant.lock;

import org.jcip.annotations.ThreadSafe;
import org.utils.ThreadUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@ThreadSafe
public class SimpleProducerConsumerV1 {

    private static final int MAX_QUEUE_CAPACITY = 5;
    private List<Integer> buffer = new ArrayList<>();
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    private static final int MAX_VALUE = 20;

    private static final int EOF = -1;

    static class Producer implements Runnable {
        private final List<Integer> buffer;
        private final ReentrantLock reentrantLock;

        public Producer(List<Integer> buffer, ReentrantLock reentrantLock) {
            this.buffer = buffer;
            this.reentrantLock = reentrantLock;
        }

        @Override
        public void run() {
            System.out.printf("[%s] Started...\n", Thread.currentThread().getName());
            for (int i = 0; i < 20; i++) {
                reentrantLock.lock();
                try {
                    int data = atomicInteger.getAndIncrement();
                    buffer.add(data);
                    System.out.printf("[%s] Value produced: %d\n", Thread.currentThread().getName(), data);
                    ThreadUtils.randomSleep(1000);
                } finally {
                    reentrantLock.unlock();
                }
            }
            reentrantLock.lock();
            try {
                buffer.add(EOF);
            } finally {
                reentrantLock.unlock();
            }
            System.out.printf("[%s] Message end Exiting...\n", Thread.currentThread().getName());
        }
    }

    static class Consumer implements Runnable {

        private final List<Integer> buffer;
        private final ReentrantLock reentrantLock;


        public Consumer(List<Integer> buffer, ReentrantLock reentrantLock) {
            this.buffer = buffer;
            this.reentrantLock = reentrantLock;
        }

        @Override
        public void run() {
            System.out.printf("[%s] Started...\n", Thread.currentThread().getName());
            while (true) {
                reentrantLock.lock();
                try {
                    if (buffer.isEmpty()) continue;
                    if (buffer.get(0).equals(EOF)) {
                        System.out.printf("[%s] Buffer EOF Exiting...\n", Thread.currentThread().getName());
                        break;
                    } else {
                        System.out.printf("[%s] Value consumed: %d\n", Thread.currentThread().getName(), buffer.remove(0));
                    }
                    ThreadUtils.randomSleep(1000);
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }

    private void runSingleProducerConsumer() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        List<Thread> threads = new ArrayList<>();
        Thread producerThread = new Thread(new Producer(buffer, reentrantLock), "Producer-1");
        Thread consumerThread1 = new Thread(new Consumer(buffer, reentrantLock), "Consumer-1");
        Thread consumerThread2 = new Thread(new Consumer(buffer, reentrantLock), "Consumer-2");

        threads.add(producerThread);
        threads.add(consumerThread1);
        threads.add(consumerThread2);

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleProducerConsumerV1 simpleProducerConsumer = new SimpleProducerConsumerV1();
        simpleProducerConsumer.runSingleProducerConsumer();
    }
}
