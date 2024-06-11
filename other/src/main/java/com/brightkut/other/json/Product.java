package com.brightkut.other.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Product {
    private String productId;
    private String productName;
    @JsonProperty("description") // use to custom response name in json response or dto
    private String productDescription;
    private String productCategory;
}
