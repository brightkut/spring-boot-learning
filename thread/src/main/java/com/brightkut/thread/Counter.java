package com.brightkut.thread;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int counter ;

    private final ReentrantLock reentrantLock = new ReentrantLock();

    private final Object lock = new Object();

    public int getAndIncrement(int index) {
        // Using synchronized block
        synchronized (lock) {
            System.out.println("Start worker " + index + " with thread " + Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Task interrupted");
            }

            System.out.println("End worker " + index + " with thread " + Thread.currentThread());
            return counter++;
        }
    }

    public int getAndIncrementReetrantLock(int index) {
        reentrantLock.lock();
        try {
            System.out.println("Start worker " + index + " with thread " + Thread.currentThread());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Task interrupted");
            }

            System.out.println("End worker " + index + " with thread " + Thread.currentThread());
            return counter++;
        }finally {
            reentrantLock.unlock();
        }
    }
}
