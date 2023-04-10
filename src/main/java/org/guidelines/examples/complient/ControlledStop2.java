package org.guidelines.examples.complient;

import org.guidelines.examples.faulty.AbstractControlledStop;

public class ControlledStop2 extends AbstractControlledStop {
    private volatile boolean done = false;

    @Override
    protected synchronized boolean isDone() {
        return done;
    }

    @Override
    public synchronized void shutdown() {
        done = true;
    }
}

