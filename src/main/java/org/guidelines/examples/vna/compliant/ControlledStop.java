package org.guidelines.examples.vna.compliant;

import org.guidelines.examples.vna.faulty.AbstractControlledStop;
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
