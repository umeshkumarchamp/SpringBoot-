package com.codizworld.codizworld.controller.JpaMapping.manytomany;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codizworld.codizworld.model.springdatajpa.manytomany.Student;
import com.codizworld.codizworld.service.StudentService;

@RestController
@RequestMapping(value = "/api/students")
public class StudentController {
    
    @Autowired
    private StudentService stdService;

    Map<String, Object> res = new HashMap<>();

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addStudent(@RequestBody Student student) {

        Student std = stdService.addStudent(student);
        if (std != null) {
            res.put("message", "Student Added Successfully.");
            res.put("status", true);
            res.put("data", std);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        res.put("message", "Something went wrong !.");
        res.put("status", false);
        res.put("data", std);
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getPersonList() {
        List<Student> list = stdService.getStudentList();
        if (list != null) {
            res.put("message", "Details Fetched Successfully.");
            res.put("status", true);
            res.put("data", list);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        res.put("message", "Something Went Wrong !.");
        res.put("status", false);
        res.put("data", list);
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
}
