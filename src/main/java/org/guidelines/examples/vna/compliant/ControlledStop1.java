package org.guidelines.examples.vna.compliant;

import org.guidelines.examples.vna.faulty.AbstractControlledStop;
import org.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicBoolean;

@ThreadSafe

public class ControlledStop1 extends AbstractControlledStop {
    private AtomicBoolean done = new AtomicBoolean(false);

    @Override
    protected boolean isDone() {
        return done.get();
    }

    @Override
    public void shutdown() {
        done.set(true);
    }
}
