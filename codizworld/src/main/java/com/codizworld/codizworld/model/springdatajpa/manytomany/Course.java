package com.codizworld.codizworld.model.springdatajpa.manytomany;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(name = "course_id", unique = true)
    private String courseId; 

    @Column(name = "course_name")
    private String courseName; 

    @Column(name = "course_fee")
    private String courseFee; 
    private String duration; 

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private Set<Student> students = new HashSet<Student>();

    public Course() {
    }

    public Course(Long id, String courseId, String courseName, String courseFee, String duration, Set<Student> students) {
        this.id = id;
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.duration = duration;
        this.students = students;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseFee() {
        return this.courseFee;
    }

    public void setCourseFee(String courseFee) {
        this.courseFee = courseFee;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", courseId='" + getCourseId() + "'" +
            ", courseName='" + getCourseName() + "'" +
            ", courseFee='" + getCourseFee() + "'" +
            ", duration='" + getDuration() + "'" +
            ", students='" + getStudents() + "'" +
            "}";
    }


    
}
