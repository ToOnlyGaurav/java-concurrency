package org.guidelines.examples.vna.faulty;


import org.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class ControlledStopRaw implements Runnable {
    private boolean done = false;

    @Override
    public void run() {
        int i = 0;
        while (!done) {
            i++;
        }
    }

    public void shutdown() {
        done = true;
    }
}
