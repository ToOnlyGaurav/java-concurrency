package org.guidelines.examples.complient;

import org.guidelines.examples.faulty.Helper;

public class Foo {
    private volatile Helper helper;

    public Helper getHelper() {
        return helper;
    }

    public void setHelper(int num) {
        helper = new Helper(num);
    }
}