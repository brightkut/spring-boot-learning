package com.brightkut.other.jasper;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CountryReport {
    private String country;
    private String name;
}
