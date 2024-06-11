package com.brightkut.other.json;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<Product> getProduct() {
        Product product = new Product()
                .setProductId("1")
                .setProductName("Macbook")
                .setProductDescription("Apple device")
                .setProductCategory("Electronics");

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(product);
    }
}
