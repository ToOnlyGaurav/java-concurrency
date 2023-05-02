package org.problems.producerconsumer.faulty;

import org.jcip.annotations.NotThreadSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@NotThreadSafe
public class SimpleProducerConsumer {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    private static final int MAX_VALUE = 20;

    private static final int EOF = -1;

    static class Producer implements Runnable {
        private final List<Integer> buffer;
        private int max;

        public Producer(List<Integer> buffer, int max) {
            this.buffer = buffer;
            this.max = max;
        }

        @Override
        public void run() {
            System.out.printf("[%s] Started...\n", Thread.currentThread().getName());
            for (int i = 0; i < 20; i++) {
                 while(buffer.size() == max) continue;
                int data = atomicInteger.getAndIncrement();
                buffer.add(data);
                System.out.printf("[%s] Value produced: %d\n", Thread.currentThread().getName(), data);
            }
            buffer.add(EOF);
            System.out.printf("[%s] Message end Exiting...\n", Thread.currentThread().getName());
        }
    }

    static class Consumer implements Runnable {

        private final List<Integer> buffer;

        public Consumer(List<Integer> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            System.out.printf("[%s] Started...\n", Thread.currentThread().getName());
            while (true) {
                if (buffer.isEmpty()) continue;
                if (buffer.get(0).equals(EOF)) {
                    System.out.printf("[%s] Buffer EOF Exiting...\n", Thread.currentThread().getName());
                    break;
                } else {
                    System.out.printf("[%s] Value consumed: %d\n", Thread.currentThread().getName(), buffer.remove(0));
                }
            }
        }
    }

    private void runSingleProducerConsumer() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        int MAX_QUEUE_CAPACITY = 5;
        List<Integer> buffer = new ArrayList<>();
        Thread producerThread = new Thread(new Producer(buffer, MAX_QUEUE_CAPACITY), "Producer-1");
        Thread consumerThread1 = new Thread(new Consumer(buffer), "Consumer-1");
        Thread consumerThread2 = new Thread(new Consumer(buffer), "Consumer-2");

        threads.add(producerThread);
        threads.add(consumerThread1);
        threads.add(consumerThread2);

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleProducerConsumer simpleProducerConsumer = new SimpleProducerConsumer();
        simpleProducerConsumer.runSingleProducerConsumer();
    }
}
