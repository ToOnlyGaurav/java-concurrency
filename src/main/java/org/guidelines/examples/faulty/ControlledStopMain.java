package org.guidelines.examples.faulty;

import java.util.concurrent.TimeUnit;

public class ControlledStopMain {
    public static void main(String[] args) throws InterruptedException {
//        AbstractControlledStop controlledStop = new ControlledStop();
//        AbstractControlledStop controlledStop = new org.guidelines.examples.complient.ControlledStop();
//        AbstractControlledStop controlledStop = new org.guidelines.examples.complient.ControlledStop1();
        AbstractControlledStop controlledStop = new org.guidelines.examples.complient.ControlledStop2();
        Thread backgroundThread = new Thread(controlledStop);
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        controlledStop.shutdown();
        backgroundThread.join();
    }
}
