package org.guidelines.examples.vna.faulty;

import org.jcip.annotations.NotThreadSafe;

@NotThreadSafe
final class Foo {
    private Helper helper;

    public Helper getHelper() {
        return helper;
    }

    public void setHelper(int num) {
        helper = new Helper(num);
    }
}
