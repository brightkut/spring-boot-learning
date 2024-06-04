package com.brightkut.caching;

import lombok.Data;

import java.io.Serializable;

// ต้องใส่ implements Serializable เพื่อให้ serializer ในการเก็บลง redis ได้
@Data
public class Product implements Serializable {
    private String productId;
    private String productName;
}
