package org.problems.memorymodel;

public class SeparateRunnable {
    public static void main(String[] args) {
        int num = 10;

        DataBag dataBag = new DataBag();

        System.out.println(dataBag);


        Runnable runnable1 = new RunnableImpl();
        Runnable runnable2 = new RunnableImpl();

        Thread thread1 = new Thread(runnable1, "Thread-1");
        Thread thread2 = new Thread(runnable2, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
