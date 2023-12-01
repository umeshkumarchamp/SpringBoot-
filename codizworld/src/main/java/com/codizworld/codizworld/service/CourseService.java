package com.codizworld.codizworld.service;

import java.util.List;

import com.codizworld.codizworld.model.springdatajpa.manytomany.Course;

public interface CourseService {
    
    public Course addCourse(Course course);

    public List<Course> getCouseList();

}
