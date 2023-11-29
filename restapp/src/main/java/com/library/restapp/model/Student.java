package com.library.restapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(name = "admission_no", nullable = false)
    private String admissionNo; 

    @Column(name = "full_name", nullable = false)
    private String fullname; 

    @Column(name = "contact", nullable = false)
    private Long contact; 

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;

    public Student() {
    }

    public Student(Long id, String admissionNo, String fullname, Long contact, Laptop laptop) {
        this.id = id;
        this.admissionNo = admissionNo;
        this.fullname = fullname;
        this.contact = contact;
        this.laptop = laptop;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdmissionNo() {
        return this.admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getContact() {
        return this.contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public Laptop getLaptop() {
        return this.laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", admissionNo='" + getAdmissionNo() + "'" +
            ", fullname='" + getFullname() + "'" +
            ", contact='" + getContact() + "'" +
            ", laptop='" + getLaptop() + "'" +
            "}";
    }
    
}
