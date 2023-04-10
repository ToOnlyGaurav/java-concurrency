package org.guidelines.examples.complient;

import java.util.concurrent.atomic.AtomicBoolean;

public class ControlledStop1 implements Runnable {
    private AtomicBoolean done = new AtomicBoolean(false);

    @Override
    public void run() {
        while (!done.get()) {
            try {
                System.out.println(System.currentTimeMillis());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void shutdown() {
        done.set(true);
    }
}
