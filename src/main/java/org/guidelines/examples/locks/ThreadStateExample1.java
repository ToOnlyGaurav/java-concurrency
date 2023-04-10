package org.guidelines.examples.locks;

public class ThreadStateExample1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        thread1.setName("MyThread");

        thread1.start();
        ThreadStatePrinter.print(thread1);
        thread1.join();
    }
}
