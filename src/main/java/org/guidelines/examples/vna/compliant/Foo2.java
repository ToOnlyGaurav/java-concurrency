package org.guidelines.examples.vna.compliant;

import org.guidelines.examples.vna.faulty.Helper;
import org.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class Foo2 {
    private AtomicReference<Helper> helperRef;

    public Helper getHelper() {
        return helperRef.get();
    }

    public void setHelper(int num) {
        helperRef.set(new Helper(num));
    }
}