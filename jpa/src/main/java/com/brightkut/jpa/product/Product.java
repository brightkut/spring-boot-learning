package com.brightkut.jpa.product;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.UUID;


@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    // add auto generate id when insert to DB
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID productId;

    // validate length of name
    @Column(length = 10)
    private String productName;

    // Set precision 3 scale 2 = 123.22
    @Column(precision = 8, scale = 2)
    private BigDecimal price;
}
