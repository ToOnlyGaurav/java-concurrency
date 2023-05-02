package org.guidelines.examples.vna.compliant;

import org.guidelines.examples.vna.faulty.Helper;
import org.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Foo {
    private volatile Helper helper;

    public Helper getHelper() {
        return helper;
    }

    public void setHelper(int num) {
        helper = new Helper(num);
    }
}