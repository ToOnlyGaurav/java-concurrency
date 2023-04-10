package org.guidelines.examples.faulty;

public class Foo implements Runnable {
    private volatile boolean done = false;
    private Helper helper;

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        foo.setHelper(10);

        Thread thread = new Thread(foo);
        thread.start();
        Thread.sleep(200);
        foo.setHelper(20);
        Thread.sleep(200);
        foo.done = true;

        thread.join();
        System.out.println("Done...");
    }

    public Helper getHelper() {
        return helper;
    }

    public void setHelper(int num) {
        helper = new Helper(num);
    }

    @Override
    public void run() {
        while (!done) {
            System.out.println("num: " + getHelper().getN());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
