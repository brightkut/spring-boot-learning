package com.brightkut.concurrency;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/concurrency")
public class ConcurrencyController {
    private final ConcurrencyService concurrencyService;

    public ConcurrencyController(ConcurrencyService concurrencyService) {
        this.concurrencyService = concurrencyService;
    }

    @GetMapping("/concurrency")
    public String doConcurrencyProcess() {
        return concurrencyService.doConcurrencyProcess();
    }

    @GetMapping("/no-concurrency")
    public String doProcess(){
        return concurrencyService.doProcess();
    }
}
