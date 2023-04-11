package org.guidelines.examples.faulty;

import java.util.ArrayList;
import java.util.List;

public class FlagMain implements Runnable {
    private final Flag flag;

    public FlagMain(Flag flag) {

        this.flag = flag;
    }

    @Override
    public void run() {
        flag.toggle();
    }

    public static void main(String[] args) {
        Flag flag = new Flag();
        System.out.println("Initial Flag: " + flag.getFlag());

        List<Thread> theads = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            theads.add(new Thread(new FlagMain(flag)));
        }
        theads.forEach(Thread::start);

        theads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("Final Flag after even time toggle: " + flag.getFlag());
    }
}
