package org.guidelines.examples.vna.compliant;

import java.util.concurrent.atomic.AtomicBoolean;

public class Flag3 {
    private AtomicBoolean flag = new AtomicBoolean(true);

    public void toggle() {
        boolean temp;
        do {
            temp = flag.get();
        } while (!flag.compareAndSet(temp, !temp));
    }

    public AtomicBoolean getFlag() {
        return flag;
    }
}
