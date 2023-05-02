
package org.problems.producerconsumer.compliant.sema;

import org.utils.ThreadUtils;

public class Consumer implements Runnable {

    private MyQueue queue;

    public Consumer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            String element = queue.get();
            System.out.println(Thread.currentThread().getName() + " consumed " + element);
            ThreadUtils.randomSleep(1000);
        }
    }
}
