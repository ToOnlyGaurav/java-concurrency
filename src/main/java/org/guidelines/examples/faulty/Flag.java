package org.guidelines.examples.faulty;

import org.jcip.annotations.NotThreadSafe;

@NotThreadSafe
final class Flag {
    private boolean flag = true;

    public void toggle() {
//        boolean tempVale = !flag;// Unsafe
//        Utils.randomSleep(10);
        flag = !flag;
    }

    public boolean getFlag() {
        return flag;
    }
}
