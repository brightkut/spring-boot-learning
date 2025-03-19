package com.brightkut.caching.product;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // อ่านค่าจาก cache ก่อนถ้าไม่เจอจะไป query DB แล้วมาเขียนลง cache
    // และ method จะ cache ค่าที่ return
    @Cacheable(value = "product", key = "#productId")
    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    // หลังจาก insert data แล้วจะ cache data
    // ใช้ @CachePut สำหรับกรณี insert หรือ update ข้อมูล และ method จะ cache ค่าที่ return
    @CachePut(value = "product", key = "#product.productId")
    public Product createProduct(Product product) {
        productRepository.createProduct(product);
        return product;
    }

    @CacheEvict(value = "product",key = "#productId")
    public void deleteProduct(String productId) {
        productRepository.deleteProduct(productId);
    }

    public Product updateProductName(String productId, String productName) {
        return productRepository.updateProductName(productId,productName);
    }
}
