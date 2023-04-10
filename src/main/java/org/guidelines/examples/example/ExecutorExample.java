package org.guidelines.examples.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new LoopTask());
        }
        executorService.shutdown();

        Thread thread = new Thread(new LoopTask());
        thread.start();

        System.out.println("Done...");
    }


}
