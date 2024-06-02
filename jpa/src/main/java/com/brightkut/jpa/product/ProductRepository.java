package com.brightkut.jpa.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    Optional<Product> findByProductName(String productName);

    Optional<List<Product>> findTop2ByOrderByPriceDesc();

    // Custom query get only 1 field for performance
    /* 1. use record
    @Query("select new com.brightkut.jpa.product.ProductName(p.productName) from Product p")
    Optional<List<ProductName>> getAllProductNames();
     */

    /* 2. use correct type */
    @Query("select p.productName from Product p")
    Optional<List<String>> getAllProductNames();

    /* 2. use projection we need to use `as` because naming convention need to match with interface object*/
    @Query("select p.productName as productName from Product p where p.price = 40000")
    Optional<ProductNameProjection> getProductName();

    List<Product> findAll(Sort sort);

    Page<Product> findAll(Pageable pageable);
}
