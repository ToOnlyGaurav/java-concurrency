package org.guidelines.examples.locks;

public class ThreadStatePrinter {
    public static void print(Thread otherThread) {
        System.out.println("Thread: " + otherThread.getName() + " is in " + otherThread.getState() + " state");
    }

}
