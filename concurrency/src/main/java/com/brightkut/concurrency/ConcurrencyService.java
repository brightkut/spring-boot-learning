package com.brightkut.concurrency;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class ConcurrencyService {

    private final Executor taskExecutor;

    public ConcurrencyService(@Qualifier("taskExecutor") Executor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    // We didn't add @Async because we manually manage the executor service
    public String doConcurrencyProcess() {
        Instant start = Instant.now();
        // Perform Parallelism task
        // add taskExecutor = to custom config thread pool (use case: we need to concern about CPU/IO)
        CompletableFuture<String> future = CompletableFuture.supplyAsync(this::doProcess1, taskExecutor)
                .exceptionally(_ -> "error1");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(this::doProcess2, taskExecutor)
                .exceptionally(_ -> "error2");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(this::doProcess3, taskExecutor)
                .exceptionally(_ -> "error3");

        CompletableFuture<Void> allCompleted = CompletableFuture.allOf(future,future2,future3);
        allCompleted.join();// this one will block the current thread until future, future2,future3 done.

        String r1 = future.join();
        String r2 = future2.join();
        String r3 = future3.join();

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toSeconds();
        String timeRes = "Time process: " + timeElapsed + " seconds";

        return "Response1: " + r1 + "\nResponse2:" + r2 + "\nResponse3:" + r3+"\nTime Total: "+timeRes;
    }

    public String doProcess(){
        Instant start = Instant.now();
        String r1 = doProcess1();
        String r2 = doProcess2();
        String r3 = doProcess3();

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toSeconds();
        String timeRes = "Time process: " + timeElapsed + " seconds";

        return "Response1: " + r1 + "\nResponse2:" + r2 + "\nResponse3:" + r3+"\nTime Total: "+timeRes;
    }

    public String doProcess1() {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            return "Error processing 1";
        }

        return "Done process 1";
    }
    public String doProcess2() {
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            return "Error processing 2";
        }

        return "Done process 2";
    }
    public String doProcess3() {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            return "Error processing 3";
        }

        return "Done process 3";
    }
}
