package org.guidelines.examples.vna.faulty;

import org.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class flag1 {
    private volatile boolean flag = true;

    public void toggle() {
        flag ^= true;
    }

    public boolean getFlag() {
        return flag;
    }
}
