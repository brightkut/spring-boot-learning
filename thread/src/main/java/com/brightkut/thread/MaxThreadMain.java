package com.brightkut.thread;

import java.util.stream.IntStream;

public class MaxThreadMain {

    public static void doTask(int i) {
        System.out.println("Task Started by " + Thread.currentThread() + " with task number: " + i);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Task interrupted");
        }
        System.out.println("Task Completed by " + Thread.currentThread() + " with task number: " + i);
    }

    public static void main(String[] args) {

        // Test out of memory
        // final int MAX_THREAD = 7000;

        final int MAX_THREAD = 10;

        IntStream.rangeClosed(1, MAX_THREAD)
                .forEach(i -> {
                    Thread.ofPlatform().start(() -> doTask(i));
                });

        System.out.println("Main thread is completed and running by " + Thread.currentThread());
    }
}
