package com.brightkut.jpa.product;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class ProductDto {
    private String productName;
    private BigDecimal price;
}
