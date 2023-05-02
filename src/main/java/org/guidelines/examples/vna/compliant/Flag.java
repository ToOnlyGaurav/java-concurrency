package org.guidelines.examples.vna.compliant;

import org.utils.ThreadUtils;

public class Flag {
    private boolean flag = true;

    public synchronized void toggle() {
        boolean tempVale = !flag;// Unsafe
        ThreadUtils.randomSleep(10);
        flag = tempVale;
    }

    public synchronized boolean getFlag() {
        return flag;
    }
}
