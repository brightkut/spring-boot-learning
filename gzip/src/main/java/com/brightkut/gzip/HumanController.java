package com.brightkut.gzip;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/humans")
public class HumanController {

    @GetMapping
    public List<Human> getHumans() {
        List<String> gender = List.of("Male", "Female");

        return IntStream.rangeClosed(1, 100_000)
                .mapToObj(h -> new Human(h, "name" + h, gender.get(new Random().nextInt(gender.size())), h)).toList();
    }
}
