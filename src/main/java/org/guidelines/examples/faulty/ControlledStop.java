package org.guidelines.examples.faulty;


import org.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class ControlledStop extends AbstractControlledStop {
    private boolean done = false;

    @Override
    protected boolean isDone() {
        return done;
    }

    @Override
    public void shutdown() {
        done = true;
    }
}
