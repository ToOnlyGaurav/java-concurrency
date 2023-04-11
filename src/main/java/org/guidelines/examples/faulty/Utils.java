package org.guidelines.examples.faulty;

public class Utils {
    public static void randomSleep(int value) {
        int s = (int) (Math.random() * value);
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
