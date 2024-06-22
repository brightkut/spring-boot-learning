package com.brightkut.other.wrapper_test;

import org.apache.logging.log4j.util.Supplier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wrapper-test")
public class WrapperTestController {



    @GetMapping("/wrapper")
    void testWrapper(){
        // Performance will drop because it new object every time
        printTimeElapsed(()->{
            Long sum = 0L;
            for(long i=0;i<Integer.MAX_VALUE;i++){
                sum+=i;
            }
            System.out.println(sum);
        });
    }

    @GetMapping("/wrapper2")
    void testWrapper2(){
        // Good performance
        printTimeElapsed(()->{
            long sum = 0L;
            for(long i=0;i<Integer.MAX_VALUE;i++){
                sum+=i;
            }
            Long s = sum;
            System.out.println(sum);
        });
    }

    @GetMapping("/primitive")
    void testWrapperPrimitive(){
        // Good performance
        printTimeElapsed(()->{
            long sum = 0L;
            for(long i=0;i<Integer.MAX_VALUE;i++){
                sum+=i;
            }
            System.out.println(sum);
        });
    }


    static void printTimeElapsed(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time elapsed: " + elapsedTime + " milliseconds");
    }

     static <T> T printTimeElapsed(Supplier<T> task) {
        long startTime = System.currentTimeMillis();
        T result = task.get();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time elapsed: " + elapsedTime + " milliseconds");
        return result;
    }
}
