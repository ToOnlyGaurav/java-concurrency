package org.guidelines.examples.complient;

public class ControlledStop implements Runnable {
    private volatile boolean done = false;

    @Override
    public void run() {
        while (!done) {
            try {
                System.out.println(System.currentTimeMillis());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void shutdown() {
        done = true;
    }
}
