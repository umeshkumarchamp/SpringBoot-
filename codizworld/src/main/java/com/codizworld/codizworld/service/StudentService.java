package com.codizworld.codizworld.service;

import java.util.List;

import com.codizworld.codizworld.model.springdatajpa.manytomany.Student;

public interface StudentService {

    public Student addStudent(Student student);

    public List<Student> getStudentList();

    
}
