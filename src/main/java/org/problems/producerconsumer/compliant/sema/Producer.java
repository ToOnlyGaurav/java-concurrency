package org.problems.producerconsumer.compliant.sema;

import org.utils.ThreadUtils;

public class Producer implements Runnable {

    private MyQueue queue;

    public Producer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            long timeMillis = System.currentTimeMillis();
            queue.put("" + timeMillis);
            System.out.println(Thread.currentThread().getName() + " produced " + timeMillis);
            ThreadUtils.randomSleep(1000);
        }
    }
}
