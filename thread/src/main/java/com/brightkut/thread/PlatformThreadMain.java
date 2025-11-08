package com.brightkut.thread;

import java.time.Duration;

public class PlatformThreadMain {

    public static void doTask1() {
        System.out.println("Task 1 is Completed by " + Thread.currentThread());
    }

    public static void doTask2()  {
        try {
            Thread.sleep(Duration.ofSeconds(5));
            System.out.println("Task 2 is Completed by " + Thread.currentThread());
        }catch (InterruptedException e){
            System.out.println("Task 2 is interrupted");
        }
    }

    public static void doTask3()  {
        System.out.println("Task 3 is Completed by " + Thread.currentThread());
    }

    // Main thread was created and started by the JVM
//    public static void main(String[] args) {
//
//        // Create Platform thread
//        var thread1 = Thread.ofPlatform().name("Thread1");
//        var thread2 = Thread.ofPlatform().name("Thread2");
//        var thread3 = Thread.ofPlatform().name("Thread3");
//
//        // Running Task 1
//        thread1.start(PlatformThreadMain::doTask1);
//
//        // Running Task 2
//        thread2.start(PlatformThreadMain::doTask2);
//
//        // Assign Task 2 to thread3 but not started yet
//        thread3.unstarted(PlatformThreadMain::doTask2);
//
//        System.out.println("Main thread is completed and running by "+ Thread.currentThread());
//    }

    public static void main(String[] args) throws InterruptedException {

        // Create Platform thread
        var thread2 = Thread.ofPlatform().name("Thread2").start(PlatformThreadMain::doTask2);
        thread2.join();

        var thread3 = Thread.ofPlatform().name("Thread3").start(PlatformThreadMain::doTask3);
        thread3.join();

        System.out.println("Main thread is completed and running by "+ Thread.currentThread());
    }
}
