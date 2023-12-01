package com.codizworld.codizworld.service_implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codizworld.codizworld.model.springdatajpa.manytomany.Course;
import com.codizworld.codizworld.model.springdatajpa.manytomany.Student;
import com.codizworld.codizworld.repository.CourseRepository;
import com.codizworld.codizworld.repository.StudentRepository;
import com.codizworld.codizworld.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository stdRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Override
    @Transactional
    public Student addStudent(Student student) {
        
        Student savedStudent = stdRepo.save(student);  // Save the student to get the generated ID
        Set<Course> courses = student.getCourses();  // Get the courses associated with the student

        // Save each course if it doesn't exist in the database
        Set<Course> savedCourses = new HashSet<>();
        for (Course course : courses) {
            Course savedCourse = saveCourseIfNotExists(course);
            savedCourses.add(savedCourse);
        }

        // Associate the saved courses with the student
        savedStudent.setCourses(savedCourses);

        // Update the student in the database with the associated courses
        return stdRepo.save(savedStudent);

    }

    private Course saveCourseIfNotExists(Course course) {
        // Try to find an existing course by courseId
        Optional<Course> existingCourseOptional = courseRepo.findByCourseId(course.getCourseId());
    
        return existingCourseOptional.orElseGet(() -> {
            // Course doesn't exist, save the new course
            return courseRepo.save(course);
        });
    }

    // private Course saveCourseIfNotExists(Course course) {
    //     // Try to find an existing course by name
    //     Optional<Course> existingCourseOptional = courseRepo.findByCourseName(course.getCourseName());

    //     if (existingCourseOptional.isPresent()) {
    //         // Course with the same name already exists, return the existing course
    //         return existingCourseOptional.get();
    //     } else {
    //         // Course doesn't exist, save the new course
    //         return courseRepo.save(course);
    //     }
    // }

    @Override
    public List<Student> getStudentList() {
        return stdRepo.findAll();
    }
}
