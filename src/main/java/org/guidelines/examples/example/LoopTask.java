package org.guidelines.examples.example;

import java.util.concurrent.TimeUnit;

public class LoopTask implements Runnable {
    private static int count = 0;
    private int id;

    public LoopTask() {
        this.id = ++count;
    }

    @Override
    public void run() {
        System.out.println("Starting #### " + id);
        for (int i = 0; i < 10; i++) {
            System.out.println("<" + id + "> Tick:" + i);
            try {
                TimeUnit.MILLISECONDS.sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println("Ending #### " + id);
    }
}