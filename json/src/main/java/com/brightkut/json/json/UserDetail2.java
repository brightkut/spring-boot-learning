package com.brightkut.json.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class UserDetail2 {
    private String name;
    private String surname;
    @JsonInclude(JsonInclude.Include.NON_NULL)// จะมี field นี้ต่อเมื่อ email ไม่ null
    private String email;
}
