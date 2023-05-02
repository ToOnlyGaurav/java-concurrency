package org.guidelines.examples.vna.compliant;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

final class KeyedCounterV1 {
    private final ConcurrentMap<String, AtomicInteger> map =
            new ConcurrentHashMap<String, AtomicInteger>();


    public void increment(String key) {
        AtomicInteger value = new AtomicInteger();
        AtomicInteger old = map.putIfAbsent(key, value);
        if (old != null) {
            value = old;
        }
        if (value.get() == Integer.MAX_VALUE) {
            throw new ArithmeticException("Out of range");
        }
        value.incrementAndGet(); // Increment the value atomically
    }


    public Integer getCount(String key) {
        AtomicInteger value = map.get(key);
        return (value == null) ? null : value.get();
    }
    // Other accessors ...
}
