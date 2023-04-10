package org.guidelines.examples.complient;

public class ControlledStop2 implements Runnable {
    private boolean done = false;

    @Override
    public void run() {
        while (!isDone()) {
            try {
                System.out.println(System.currentTimeMillis());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void shutdown() {
        done = true;
    }

    private synchronized boolean isDone() {
        return done;
    }
}
