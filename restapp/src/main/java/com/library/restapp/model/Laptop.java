package com.library.restapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(name = "model_number")
    private String modelNumber; 

    @Column(name = "brand_name")
    private String brandName; 

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;


    public Laptop() {
    }

    public Laptop(Long id, String modelNumber, String brandName, Student student) {
        this.id = id;
        this.modelNumber = modelNumber;
        this.brandName = brandName;
        this.student = student;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelNumber() {
        return this.modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", modelNumber='" + getModelNumber() + "'" +
            ", brandName='" + getBrandName() + "'" +
            ", student='" + getStudent() + "'" +
            "}";
    }
    

}
