package com.myblog.myblog11.controller;

import com.myblog.myblog11.entity.Student;
import com.myblog.myblog11.payload.StudentDto;
import com.myblog.myblog11.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/display")
// http://localhost:8080/api/display
public class StudentController {

    private StudentRepository studentrepo;

    public StudentController(StudentRepository studentrepo) {
        this.studentrepo = studentrepo;
    }

    @PostMapping
    public ResponseEntity<?> saveData(@RequestBody Student s1 ) {

        studentrepo.save(s1);
return new ResponseEntity<>("The data is saved!!", HttpStatus.CREATED);
    }
}
