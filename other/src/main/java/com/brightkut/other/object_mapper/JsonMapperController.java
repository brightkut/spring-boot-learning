package com.brightkut.other.object_mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/json")
public class JsonMapperController {

    private final JsonMapperService jsonMapperService;

    public JsonMapperController(JsonMapperService jsonMapperService) {
        this.jsonMapperService = jsonMapperService;
    }

    @GetMapping
    public ResponseEntity<Product> readJsonFileToProduct() throws IOException {
        return ResponseEntity.ok(jsonMapperService.readJsonFileToProductObject());
    }

    @PostMapping
    public ResponseEntity<String> convertProductToString(@RequestBody Product product) throws JsonProcessingException {
        return ResponseEntity.ok(jsonMapperService.convertProductToString(product));
    }
}
