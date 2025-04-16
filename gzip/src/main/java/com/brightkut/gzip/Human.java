package com.brightkut.gzip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Human {
    private Integer humanId;
    private String name;
    private String gender;
    private Integer age;
}
