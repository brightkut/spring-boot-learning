package com.brightkut.custom_annotation.annotation;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintHelloAspect {

    @Around("@annotation(printHello)")
    public Object printHello(ProceedingJoinPoint joinPoint, PrintHello printHello){
        try {
            for (int i = 0; i < printHello.times(); i++) {
                System.out.println("Hello");
            }
            return joinPoint.proceed(); // Proceed with the original method execution
        }catch (Throwable ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}
