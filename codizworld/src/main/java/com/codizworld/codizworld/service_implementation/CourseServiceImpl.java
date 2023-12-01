package com.codizworld.codizworld.service_implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codizworld.codizworld.model.springdatajpa.manytomany.Course;
import com.codizworld.codizworld.model.springdatajpa.manytomany.Student;
import com.codizworld.codizworld.repository.CourseRepository;
import com.codizworld.codizworld.repository.StudentRepository;
import com.codizworld.codizworld.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private StudentRepository stdRepo;

    @Override
    public Course addCourse(Course course) {

        Course savedCourse = courseRepo.save(course);
        Set<Student> students = course.getStudents();
        Set<Student> savedStudents = new HashSet<>();
        for (Student student : students) {
            Student saveStudent = saveStudentIfNotExists(student);
            savedStudents.add(saveStudent);
        }
        savedCourse.setStudents(savedStudents);      
        return courseRepo.save(savedCourse);
    }

    private Student saveStudentIfNotExists(Student student) {
        Optional<Student> existingStudent = stdRepo.findStudentByAdmissionNo(student.getAdmissionNo());
        return existingStudent.orElseGet(() -> stdRepo.save(student));
    }

    @Override
    public List<Course> getCouseList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCouseList'");
    }

}
