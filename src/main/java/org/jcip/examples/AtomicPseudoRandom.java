package org.jcip.examples;

import org.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;


@ThreadSafe
public class AtomicPseudoRandom extends PseudoRandom {
    private final AtomicInteger seed;

    AtomicPseudoRandom(int seed) {
        this.seed = new AtomicInteger(seed);
    }

    public int nextInt(int n) {
        while (true) {
            int s = seed.get();
            int nextSeed = calculateNext(s);
            if (seed.compareAndSet(s, nextSeed)) {
                int remainder = s % n;
                return remainder > 0 ? remainder : remainder + n;
            }
        }
    }
}
