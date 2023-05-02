package org.guidelines.examples.faulty;

public class JavaObjectMonitor {
    public static void main(String args[]) {
        Monitor monitor = new Monitor();
        Runnable thread1 = () -> monitor.method1();
        new Thread(thread1).start();
        Runnable thread2 = () -> monitor.method2();
        new Thread(thread2).start();
    }
}

class Monitor {
    public synchronized void method1() {
        System.out.println("Inside Method 1");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Exit from method1");
    }

    public void method2() {
        System.out.println("Inside Method 2");
    }
}
