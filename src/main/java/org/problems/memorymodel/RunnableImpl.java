package org.problems.memorymodel;

public class RunnableImpl implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            synchronized (this)
            {
                count++;
            }
        }

        System.out.println("Thread: " + Thread.currentThread().getName() + " -> count: " + count);
    }
}