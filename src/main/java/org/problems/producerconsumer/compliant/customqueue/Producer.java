package org.problems.producerconsumer.compliant.customqueue;

import org.utils.ThreadUtils;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer<T> implements Runnable {
    private final DataQueue<T> dataQueue;
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    private static int idSequence = 0;

    public Producer(DataQueue<T> dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        produce();
    }

    public void produce() {
        while (dataQueue.runFlag) {
            synchronized (this) {
                while (dataQueue.isFull() && dataQueue.runFlag) {
                    try {
                        dataQueue.waitOnFull();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                if (!dataQueue.runFlag) {
                    break;
                }
                Message<T> message = generateMessage();
                dataQueue.add(message);
                dataQueue.notifyAllForEmpty();
            }
        }
        System.out.println("Producer Stopped");
    }

    private Message<T> generateMessage() {
        Message<T> message = (Message<T>) new Message<>(++idSequence, atomicInteger.getAndIncrement());
        System.out.printf("[%s] Generated Message. Id: %d, Data: %d\n", Thread.currentThread().getName(), message.getId(), message.getData());

        ThreadUtils.randomSleep(100);

        return message;
    }

    public void stop() {
        dataQueue.runFlag = false;
        dataQueue.notifyAllForFull();
    }
}