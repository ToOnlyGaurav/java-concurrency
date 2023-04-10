package org.guidelines.examples.faulty;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Singleton {
    static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        int[] argumentPositionsForKey = {1, 2};
        List<Integer> argumentPositionsForKeyList = Arrays.stream(argumentPositionsForKey)
                .boxed().collect(Collectors.toList());

        IntStream.of(argumentPositionsForKey).boxed().collect(Collectors.toList());

        Singleton singleton = new Singleton();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Handle(singleton));
        }

        Thread.sleep(1000);
        executorService.shutdown();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 1) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

    }

    void doOperation() throws InterruptedException {
        int id = atomicInteger.getAndIncrement();

        int sleep = (int) Math.abs(Math.random() * 1000);
        System.out.println(Thread.currentThread().getName() + ", Sleeping for : " + sleep + " generated id: " + id);
        Thread.sleep(sleep);


        System.out.println("Processing: " + Thread.currentThread().getName() + " generated id: " + id);
        Integer orDefault = map.getOrDefault(id, 0);
        sleep = (int) Math.abs(Math.random() * 1000);
        System.out.println(Thread.currentThread().getName() + ", Sleeping for : " + sleep + " generated id: " + id);
        Thread.sleep(sleep);

        System.out.println("Processing: " + Thread.currentThread().getName() + " generated id: " + id);
        map.putIfAbsent(id, orDefault + 1);
    }

    static class Handle implements Runnable {

        private Singleton singleton;

        public Handle(Singleton singleton) {

            this.singleton = singleton;
        }

        @Override
        public void run() {
            try {
                singleton.doOperation();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
