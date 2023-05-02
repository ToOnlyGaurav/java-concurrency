package org.guidelines.examples.threads.faulty;

import org.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public final class Foo implements Runnable {
    @Override
    public void run() {
        System.out.println("Helo world: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(foo).run();
    }
}
