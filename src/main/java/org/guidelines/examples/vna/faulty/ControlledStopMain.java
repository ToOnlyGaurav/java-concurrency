package org.guidelines.examples.vna.faulty;

import org.guidelines.examples.vna.compliant.ControlledStop1;

import java.util.concurrent.TimeUnit;

public class ControlledStopMain {
    public static void main(String[] args) throws InterruptedException {
//        AbstractControlledStop controlledStop = new ControlledStop();
//        AbstractControlledStop controlledStop = new org.guidelines.examples.vna.compliant.ControlledStop();
        AbstractControlledStop controlledStop = new ControlledStop1();
//        AbstractControlledStop controlledStop = new org.guidelines.examples.vna.compliant.ControlledStop2();
        Thread backgroundThread = new Thread(controlledStop);
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        controlledStop.shutdown();
        backgroundThread.join();
    }
}
