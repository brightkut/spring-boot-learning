package com.brightkut.performance;

import org.apache.logging.log4j.util.Supplier;

public class Util {

    private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static void printMemoryUsed(){
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));
    }

    public static <T> T measureExecutionTime(Supplier<T> function) {
        long startTime = System.nanoTime();
        T result = function.get();
        long endTime = System.nanoTime();

        long durationInMillis = (endTime - startTime) / 1_000_000;
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;

        System.out.println("Execution time: " + durationInMillis + " milliseconds (" + durationInSeconds + " seconds)");
        return result;
    }
}
