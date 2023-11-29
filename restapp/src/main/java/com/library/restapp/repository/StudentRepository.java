package com.library.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.restapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
