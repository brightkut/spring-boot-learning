package com.brightkut.caching.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public Product getProductById(String productId) {
        return products.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Product not found"));
    }

    public void createProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(String productId) {
        products.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .ifPresent(products::remove);
    }

    public Product updateProductName(String productId, String productName) {
        Optional<Product> getProduct = products.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst();

        if (getProduct.isPresent()){
            products.stream()
                    .filter(product -> product.getProductId().equals(productId))
                    .findFirst()
                    .ifPresent(product -> product.setProductName(productName));

            getProduct.get().setProductName(productName);

            return getProduct.get();
        }

        return null;
    }
}
