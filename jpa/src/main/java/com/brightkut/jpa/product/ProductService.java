package com.brightkut.jpa.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // add this @Transactional in service layer to make this function as transaction
    @Transactional(rollbackFor = Exception.class)
    public Product addProduct(ProductDto productDto) {
          Product product = new Product()
                  .setProductName(productDto.getProductName())
                  .setPrice(productDto.getPrice());

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductsByName(String productName) {
        return productRepository.findByProductName(productName)
                .orElseThrow(()-> new RuntimeException("Error product not found"));
    }

    public List<Product> getProductsTop2OrderByPrice() {
        return productRepository.findTop2ByOrderByPriceDesc()
                .orElseThrow(()-> new RuntimeException("Error product not found"));
    }

    // option1
//    public List<ProductName> getAllProductNames() {
//        return productRepository.getAllProductNames()
//                .orElseThrow(()-> new RuntimeException("Error product not found"));
//    }

    // option2
    public List<String> getAllProductNames() {
        return productRepository.getAllProductNames()
                .orElseThrow(()-> new RuntimeException("Error product not found"));
    }

    // option3
    public ProductNameProjection getProductName() {
        return productRepository.getProductName()
                .orElseThrow(()-> new RuntimeException("Error product not found"));
    }

    public List<Product> getProductSort(){
        return productRepository.findAll(
                Sort.by( "price").descending()
                        .and(Sort.by("productName").ascending()));
    }

    public PageResult<Product> getProductPage(int page, int size) {
        Pageable pageable = PageRequest.of(page -1 , size,Sort.by("price").descending());

        Page<Product> products = productRepository.findAll(pageable);

        return new PageResult<>(
                products.getContent(),
                products.getTotalElements(),
                products.getTotalPages(),
                products.getNumber() +1
        );
    }
}
