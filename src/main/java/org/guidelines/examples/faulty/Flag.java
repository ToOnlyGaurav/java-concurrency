package org.guidelines.examples.faulty;

import org.guidelines.examples.annotation.NotThreadSafe;

import java.util.ArrayList;
import java.util.List;

@NotThreadSafe
public class Flag {
    private boolean flag = true; //volatile will also not help

    public static void main(String[] args) throws InterruptedException {
        Flag flag = new Flag();
        System.out.println("Flag: " + flag.flag);

        List<Thread> theads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            theads.add(new Thread(new FlagChange(flag)));
        }
        theads.forEach(thread -> thread.start());

        theads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("Flag: " + flag.flag);
    }

    public void toggle() {  // Unsafe
        boolean oldFlag = flag;
        randomSleep();
        flag = !oldFlag;
    }

    private void randomSleep() {
        int s = (int) (Math.random() * 100);
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean getFlag() { // Unsafe
        return flag;
    }

    static class FlagChange implements Runnable {
        private Flag flag;

        public FlagChange(Flag flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            flag.toggle();
        }
    }
}
