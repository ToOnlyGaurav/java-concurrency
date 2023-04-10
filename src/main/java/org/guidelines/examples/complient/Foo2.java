package org.guidelines.examples.complient;

import org.guidelines.examples.faulty.Helper;

import java.util.concurrent.atomic.AtomicReference;

public class Foo2 {
    private AtomicReference<Helper> helperRef;

    public Helper getHelper() {
        return helperRef.get();
    }

    public void setHelper(int num) {
        helperRef.set(new Helper(num));
    }
}