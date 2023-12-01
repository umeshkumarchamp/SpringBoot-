package com.codizworld.codizworld.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codizworld.codizworld.model.springdatajpa.manytomany.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

    @Query(value="SELECT * FROM students WHERE admission_no = :admission_no LIMIT 1", nativeQuery=true)
    Optional<Student> findStudentByAdmissionNo(@Param("admission_no") String admissionNo);
    
}
