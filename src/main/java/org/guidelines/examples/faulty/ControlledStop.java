package org.guidelines.examples.faulty;

import org.apache.log4j.Logger;
import org.guidelines.examples.annotation.NotThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@NotThreadSafe
public class ControlledStop implements Runnable {
    private boolean done = false;
    private static final Logger logger = Logger.getLogger("ControlledStop");


    public static void main(String[] args) throws InterruptedException {

        ControlledStop controlledStop = new ControlledStop();
        Thread thread1 = new Thread(controlledStop);
        thread1.start();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Thread(controlledStop));
        }


        //System.out.println("Making shutdown");
        logger.debug("Making shutdown");
        controlledStop.shutdown();
        logger.debug("Shutdown complete");
        //System.out.println("Shutdown complete");

        thread1.join();
        //Thread.sleep(10);
        executorService.shutdown();
//        System.out.println("Done..");
        logger.debug("Done...");
    }

    @Override
    public void run() {
        while (!done) {
            try {
                logger.debug("" + System.currentTimeMillis());
                //System.out.println(System.currentTimeMillis());
                //Thread.sleep(1000);
            } finally {
            }
        }
    }

    public void shutdown() {
        done = true;
    }
}
