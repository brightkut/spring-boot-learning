package com.brightkut.json.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
    private String username;
    // Annotation นี้จะไม่ return field นี้ออกไปใน output json
    @JsonIgnore
    private String password;
}
