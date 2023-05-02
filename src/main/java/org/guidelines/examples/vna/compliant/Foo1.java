package org.guidelines.examples.vna.compliant;

import org.guidelines.examples.vna.faulty.Helper;
import org.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Foo1 {
    private Helper helper;

    public synchronized Helper getHelper() {
        return helper;
    }

    public synchronized void setHelper(int num) {
        helper = new Helper(num);
    }
}