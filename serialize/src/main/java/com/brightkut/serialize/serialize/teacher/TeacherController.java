package com.brightkut.serialize.serialize.teacher;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @GetMapping
    public ResponseEntity<Teacher> getTeachers(){
        Teacher teacher = new Teacher();
        teacher.setName("Boby");
        teacher.setBirthDate(ZonedDateTime.now());

        return ResponseEntity.ok(teacher);
    }

    @PostMapping
    public ResponseEntity<String> createTeacher(@RequestBody Teacher teacher){
        String res = "Teacher name: " + teacher.getName() + ", birth date: " + teacher.getBirthDate();

        return ResponseEntity.ok(res);
    }
}
