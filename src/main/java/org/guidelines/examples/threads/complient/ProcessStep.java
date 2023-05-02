package org.guidelines.examples.threads.complient;

public final class ProcessStep implements Runnable {
    private static final Object lock = new Object();
    private static int time = 0;
    private final int step; // Perform operations when field time

    // reaches this value
    public ProcessStep(int step) {
        this.step = step;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (time != step) {
                    System.out.printf("step: %d, time: %d, waiting...%n", step, time);
                    lock.wait();
                }

                Thread.sleep(100);
                System.out.printf("step: %d, time: %d, Processing...\n", step, time);

                // Perform operations

                time++;
                //lock.notifyAll(); // Use notifyAll() instead of notify()
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt(); // Reset interrupted status
        }
    }

    public static void main(String[] args) {
        for (int i = 4; i >= 0; i--) {
            new Thread(new ProcessStep(i)).start();
        }
    }

}