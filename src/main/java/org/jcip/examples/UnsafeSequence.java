package org.jcip.examples;

import org.jcip.annotations.NotThreadSafe;


@NotThreadSafe
public class UnsafeSequence {
    private int value;


    public int getNext() {
        return value++;
    }
}
