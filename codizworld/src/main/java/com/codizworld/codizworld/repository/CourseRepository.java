package com.codizworld.codizworld.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codizworld.codizworld.model.springdatajpa.manytomany.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

    @Query(value="SELECT * FROM courses WHERE course_name = :coursename LIMIT 1", nativeQuery=true)
    Optional<Course> findByCourseName(@Param("coursename") String courseName);

    Optional<Course> findByCourseId(String courseId);

    
}
