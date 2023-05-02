package org.problems.producerconsumer.compliant.sema;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class MyQueue {
    private Queue<String> internal = new LinkedList<>();


    static Semaphore Con = new Semaphore(0);
    static Semaphore Prod = new Semaphore(1);

    public String get() {
        try {
            // Before consumer can consume an item,
            // it must acquire a permit from Con
            Con.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        try {
            String remove = internal.remove();
            // consumer consuming an item
            System.out.println("Consumer consumed item: " + remove);

            // After consumer consumes the item,
            // it releases Prod to notify producer
            return remove;
        } finally {
            Prod.release();
        }
    }

    void put(String item) {
        try {
            // Before producer can produce an item,
            // it must acquire a permit from Prod
            Prod.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        // producer producing an item
        internal.add(item);
        System.out.println("Producer produced item: " + item);

        // After producer produces the item,
        // it releases Con to notify consumer
        Con.release();
    }
}
