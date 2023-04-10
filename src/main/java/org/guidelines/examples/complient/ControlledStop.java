package org.guidelines.examples.complient;

import org.guidelines.examples.faulty.AbstractControlledStop;
import org.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ControlledStop extends AbstractControlledStop {
    private volatile boolean done = false;

    @Override
    protected boolean isDone() {
        return done;
    }

    @Override
    public void shutdown() {
        done = true;
    }
}
