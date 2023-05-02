package org.guidelines.examples.threads.complient;


import org.jcip.annotations.ThreadSafe;

@ThreadSafe
public final class Foo implements Runnable {
    @Override
    public void run() {
        System.out.println("Helo world: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(foo).start();
    }
}
