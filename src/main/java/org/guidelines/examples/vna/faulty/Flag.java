package org.guidelines.examples.vna.faulty;

import org.jcip.annotations.NotThreadSafe;
import org.utils.ThreadUtils;

@NotThreadSafe
final class Flag {
    private boolean flag = true;

    public void toggle() {
        boolean tempVale = !flag;// Unsafe
        ThreadUtils.randomSleep(10);
        flag = tempVale;
    }

    public boolean getFlag() {
        return flag;
    }
}
