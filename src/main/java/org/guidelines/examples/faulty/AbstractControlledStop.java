package org.guidelines.examples.faulty;


public abstract class AbstractControlledStop implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (!isDone()) {
            i++;
        }
    }

    protected abstract boolean isDone();

    public abstract void shutdown();
}
