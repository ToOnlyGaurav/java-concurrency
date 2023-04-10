package org.guidelines.examples.faulty;

public class Visiblity implements Runnable {
    private int x;
    private volatile boolean ready;

    public static void main(String[] args) throws InterruptedException {
        Visiblity visiblity = new Visiblity();
        Thread thread = new Thread(visiblity);
        thread.start();
        visiblity.ready=true;
//        Thread.sleep(100);
        visiblity.x=200;
        Thread another = new Thread(new Runnable() {
            @Override
            public void run() {
                visiblity.x = 100;
                visiblity.ready = true;
            }
        });
//        another.start();
//        another.join();
        thread.join();
    }

    @Override
    public void run() {
        while (!ready) ;
        System.out.println("x: " + x);
    }
}
