package org.guidelines.examples.vna.faulty;

import org.jcip.annotations.NotThreadSafe;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

@NotThreadSafe
final class Adder {
    // AtomicReference is an object reference that can be updated atomically
    private final AtomicReference<BigInteger> first;
    private final AtomicReference<BigInteger> second;

    public Adder(BigInteger f, BigInteger s) {
        first = new AtomicReference<BigInteger>(f);
        second = new AtomicReference<BigInteger>(s);
    }

    public void update(BigInteger f, BigInteger s) { // Unsafe
        first.set(f);
        second.set(s);
    }

    public BigInteger add() { // Unsafe
        return first.get().add(second.get());
    }
}
