package com.brightkut.other.serialize;

import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class StudentService {
    public Student getStudent() {
        Student student = new Student();
        student.setName("Boby");
        student.setAge(18);
        ZonedDateTime now = ZonedDateTime.now();
        student.setBirthDate(now);

        return student;
    }

    public Student createStudent(Student student) {
        return student;
    }
}
