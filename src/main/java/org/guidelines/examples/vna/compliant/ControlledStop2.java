package org.guidelines.examples.vna.compliant;

import org.guidelines.examples.vna.faulty.AbstractControlledStop;

public class ControlledStop2 extends AbstractControlledStop {
    private boolean done = false;

    @Override
    protected synchronized boolean isDone() {
        return done;
    }

    @Override
    public synchronized void shutdown() {
        done = true;
    }
}

