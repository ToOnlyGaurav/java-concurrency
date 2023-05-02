package org.problems.memorymodel;

public class SingleRunnable {
    public static void main(String[] args) {
        Runnable runnable1 = new RunnableImpl();

        Thread thread1 = new Thread(runnable1, "Thread-1");
        Thread thread2 = new Thread(runnable1, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
