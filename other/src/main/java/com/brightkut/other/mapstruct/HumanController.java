package com.brightkut.other.mapstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
