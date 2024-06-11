package com.brightkut.other.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
// ไม่ส่ง field name กับ surname ออกไป ใน output endpoint
@JsonIgnoreProperties({"name","surname"})
//@JsonIgnoreProperties(ignoreUnknown = true) // ใช้กรณีที่ map จาก api แล้วกลัวเค้า return field เกินมา
public class UserDetail {
    private String name;
    private String surname;
    private String email;
}
