package com.brightkut.other.serialize;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Student {
    private String name;
    private int age;
    // ใช้ serializer ที่ custom ( serializer = แปลงจาก object ใน code เป็น json response)
    // return 2024-12-01 01:01:01
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    // ใช้ deserializer ที่ custom (deserializer = json request -> object)
    // receive 01-12-2024
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    ZonedDateTime birthDate;
}
