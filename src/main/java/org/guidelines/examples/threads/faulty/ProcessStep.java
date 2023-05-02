package org.guidelines.examples.threads.faulty;

public final class ProcessStep implements Runnable {
    private static final Object lock = new Object();
    private static int time = 0;
    private final int step; // Do Perform operations when field time
    // reaches this value

    public ProcessStep(int step) {
        this.step = step;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (time != step) {
                    System.out.println("step: " + step + ", waiting...");
                    lock.wait();
                }

                Thread.sleep(10);
                System.out.println("step: " + step + ", processing...");
                // Perform operations

                time++;
                lock.notify();
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
