package org.guidelines.examples.complient;

import org.guidelines.examples.faulty.Helper;

public class Foo1 {
    private Helper helper;

    public synchronized Helper getHelper() {
        return helper;
    }

    public synchronized void setHelper(int num) {
        helper = new Helper(num);
    }
}