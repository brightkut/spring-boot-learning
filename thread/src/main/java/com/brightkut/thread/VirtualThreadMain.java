
package com.brightkut.thread;

import java.util.stream.IntStream;

public class VirtualThreadMain {

    public static void doTask(int i){
        System.out.println("Task Started by " + Thread.currentThread() + " with task number: " + i);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Task interrupted");
        }
        System.out.println("Task Completed by " + Thread.currentThread() + " with task number: " + i);
    }

	public static int getNumberOfCores(){
		return Runtime.getRuntime().availableProcessors();
	}

    public static void main(String[] args) throws InterruptedException {

        // Create Virtual thread
        final int MAX_THREAD = 100_000;
		//
		// // You will see the worker who run doTask() and the worker who run doTask() after block process it is not the same
		//       IntStream.rangeClosed(1, MAX_THREAD)
		//               .forEach(i -> {
		//                   Thread.ofVirtual().start(() -> doTask(i));
		//               });
		//       System.out.println("Main thread is completed and running by "+ Thread.currentThread());

		System.out.println("number of cores"+ getNumberOfCores());
    }
}
