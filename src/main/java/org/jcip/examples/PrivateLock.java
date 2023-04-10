package org.jcip.examples;

import org.jcip.annotations.GuardedBy;


public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock")
    Object widget;

    void someMethod() {
        synchronized (myLock) {
            // Access or modify the state of widget
        }
    }
}
