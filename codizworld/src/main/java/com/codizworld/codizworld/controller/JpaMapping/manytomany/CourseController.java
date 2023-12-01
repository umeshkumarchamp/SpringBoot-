package com.codizworld.codizworld.controller.JpaMapping.manytomany;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codizworld.codizworld.model.springdatajpa.manytomany.Course;
import com.codizworld.codizworld.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    Map<String, Object> res = new HashMap<>();

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addCourse(@RequestBody Course course) {

        Course cs = courseService.addCourse(course);
        if (cs != null) {
            res.put("message", "Course Added Successfully.");
            res.put("status", true);
            res.put("data", cs);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        res.put("message", "Something went wrong !.");
        res.put("status", false);
        res.put("data", cs);
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
