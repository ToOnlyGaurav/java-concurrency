package org.guidelines.examples.locks;

import java.util.List;

public class ReportingThread extends Thread {
    private List<Thread> threads;
    private volatile boolean report = true;

    public ReportingThread(List<Thread> threads) {
        setName("ReportingThread");
        this.threads = threads;
    }

    @Override
    public void run() {
        while (report) {
            for (Thread thread : threads) {
                System.out.println("Thread: " + thread.getName() + " is in " + thread.getState() + " state");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void stopReporting() {
        report = false;
    }
}
