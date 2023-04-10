package org.jcip.examples;

import org.jcip.annotations.GuardedBy;
import org.jcip.annotations.ThreadSafe;


@ThreadSafe
public class Sequence {
    @GuardedBy("this")
    private int nextValue;

    public synchronized int getNext() {
        return nextValue++;
    }
}
