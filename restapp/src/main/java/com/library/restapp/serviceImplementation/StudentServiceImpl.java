package com.library.restapp.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.restapp.model.Student;
import com.library.restapp.repository.StudentRepository;
import com.library.restapp.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository stdRepo;

    @Override
    public Student addStudent(Student student) {
        Student std = stdRepo.save(student);
        return std;
    }
    
}
