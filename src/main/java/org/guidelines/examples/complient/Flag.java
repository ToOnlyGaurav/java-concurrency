package org.guidelines.examples.complient;

import org.guidelines.examples.faulty.Utils;

public class Flag {
    private boolean flag = true;

    public synchronized void toggle() {
        boolean tempVale = !flag;// Unsafe
        Utils.randomSleep(10);
        flag = tempVale;
    }

    public synchronized boolean getFlag() {
        return flag;
    }
}
