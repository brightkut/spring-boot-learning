package com.brightkut.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class PinnedVirtualThreadMain {

    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        final int MAX_THREAD = 10;

        var threads = new ArrayList<Thread>();

        IntStream.rangeClosed(1, MAX_THREAD)
                .forEach(i -> {
                    var t =  Thread.ofVirtual().start(() -> new Counter().getAndIncrement(i));
//                    var t =  Thread.ofVirtual().start(() -> new Counter().getAndIncrementReetrantLock(i));
                    threads.add(t);
                    atomicInteger.incrementAndGet();
                    System.out.println("Number of threads: " + atomicInteger.get());
                });

        for(Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Task interrupted");
            }
        }
    }
}
