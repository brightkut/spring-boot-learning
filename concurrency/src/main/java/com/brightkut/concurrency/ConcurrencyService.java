package com.brightkut.concurrency;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

@Service
public class ConcurrencyService {

    public String doConcurrencyProcess() {
        Instant start = Instant.now();
        // Perform result-producing task
        CompletableFuture<String> future = CompletableFuture.supplyAsync(this::doProcess1)
                .exceptionally(ex-> "error1");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(this::doProcess2)
                .exceptionally(ex-> "error2");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(this::doProcess3)
                .exceptionally(ex-> "error3");

        CompletableFuture<Void> allCompleted = CompletableFuture.allOf(future,future2,future3);
        allCompleted.join();// this one will block current thread until  future,future2,future3 done.

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
