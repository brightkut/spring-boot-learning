package com.brightkut.mapstruct.mapstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/humans")
public class HumanController {

    private final HumanMapper humanMapper;
    public HumanController(HumanMapper humanMapper) {
        this.humanMapper = humanMapper;
    }

    @PostMapping
    public ResponseEntity<Human> createHuman(@RequestBody HumanDto dto) {
        return ResponseEntity.ok(humanMapper.humanDtoToHuman(dto,"male"));
    }

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test Human");
    }
}
