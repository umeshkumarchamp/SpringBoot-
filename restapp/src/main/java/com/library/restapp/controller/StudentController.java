package com.library.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.restapp.model.Student;
import com.library.restapp.services.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @PostMapping("api/student/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student std = studentService.addStudent(student);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }

}
