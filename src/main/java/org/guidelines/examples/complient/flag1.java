package org.guidelines.examples.complient;

public class flag1 {
    private volatile boolean flag = true;

    public synchronized void toggle() {
        flag ^= true; // Same as flag = !flag;
    }

    public boolean getFlag() {
        return flag;
    }
}
