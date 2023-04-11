package org.guidelines.examples.example;

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        printHelloWorld();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                printHelloWorld();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        });
        thread.start();

        Thread thread1 = new HelloThread();
        thread1.start();



        thread1.join();
        thread.join();
    }

    public static void printHelloWorld() {
        System.out.println("Hello World from Thread:id:" + Thread.currentThread().getId() + "Thread:name:" + Thread.currentThread().getName());
    }

    static class HelloThread extends Thread {
        @Override
        public void run() {
            printHelloWorld();
        }
    }
}
