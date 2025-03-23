package com.brightkut.custom_annotation.annotation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    @PrintHello(times = 5)
    ResponseEntity<String> test(){
        System.out.println("Method Running");
        return ResponseEntity.ok("Test pass");
    }
}
