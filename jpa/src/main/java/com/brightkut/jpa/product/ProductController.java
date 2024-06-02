package com.brightkut.jpa.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody  ProductDto product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/name")
    public ResponseEntity<Product> getProductByName(@RequestParam(value = "product_name") String productName) {
        return ResponseEntity.ok(productService.getProductsByName(productName));
    }

    @GetMapping("/top")
    public ResponseEntity<List<Product>> getProductsTop2OrderByPrice() {
        return ResponseEntity.ok(productService.getProductsTop2OrderByPrice());
    }

    //option1
//    @GetMapping("/all-name")
//    public ResponseEntity<List<ProductName>> getAllProductNames() {
//        return ResponseEntity.ok(productService.getAllProductNames());
//    }

    //option2
    @GetMapping("/all-name")
    public ResponseEntity<List<String>> getAllProductNames() {
        return ResponseEntity.ok(productService.getAllProductNames());
    }

    //option3
    @GetMapping("/only-name")
    public ResponseEntity<ProductNameProjection> getProductNamesOnly() {
        return ResponseEntity.ok(productService.getProductName());
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Product>> getProductSort() {
        return ResponseEntity.ok(productService.getProductSort());
    }

    @GetMapping("/page")
    public ResponseEntity<PageResult<Product>> getProductPagination(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(productService.getProductPage(page,size));
    }
}
