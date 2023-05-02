package org.problems.producerconsumer.compliant.customqueue;

public class Consumer<T> implements Runnable {
    private final DataQueue<T> dataQueue;

    public Consumer(DataQueue<T> dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        consume();
    }

    public void consume() {
        while (dataQueue.runFlag) {
            synchronized (this) {
                while (dataQueue.isEmpty() && dataQueue.runFlag) {
                    try {
                        dataQueue.waitOnEmpty();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                if (!dataQueue.runFlag) {
                    break;
                }
                Message<T> message = (Message<T>) dataQueue.remove();
                dataQueue.notifyAllForFull();
                useMessage(message);
            }
        }
        System.out.println("Consumer Stopped");
    }

    private void useMessage(Message<T> message) {
        if (message != null) {
            System.out.printf("[%s] Consuming Message. Id: %d, Data: %d\n", Thread.currentThread().getName(), message.getId(), (Integer)message.getData());
        }
    }

    public void stop() {
        dataQueue.runFlag = false;
        dataQueue.notifyAllForEmpty();
    }
}
