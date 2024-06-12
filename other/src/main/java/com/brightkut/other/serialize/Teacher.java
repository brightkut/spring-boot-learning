package com.brightkut.other.serialize;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Teacher {
    private String name;
    // ใช้ทั้ง serialize และ deserialize แต่ custom ได้น้อยกว่า ถ้าใช้กับ zone date time ต้องมี time zone ด้วย
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok",pattern = "dd-MM-yyyy'T'HH:mm:ss.SSSZ")
    private ZonedDateTime birthDate;
}
