package org.jcip.examples;

import java.util.concurrent.Executor;


public class WithinThreadExecutor implements Executor {
    public void execute(Runnable r) {
        r.run();
    }

}
