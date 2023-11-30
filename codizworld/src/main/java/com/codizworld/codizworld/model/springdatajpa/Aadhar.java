package com.codizworld.codizworld.model.springdatajpa;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "aadhars")
public class Aadhar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "aadhar_number", length = 12, unique = true)
    private Long aadharNumber;

    @Column(name = "full_name")
    private String fullname;

    private String gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String contact;
    private String address;

    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    @JsonIgnore
    private Person person; 

    public Aadhar() {
    }

    public Aadhar(int id, Long aadharNumber, String fullname, String gender, LocalDate dateOfBirth, String contact, String address, Person person) {
        this.id = id;
        this.aadharNumber = aadharNumber;
        this.fullname = fullname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
        this.address = address;
        this.person = person;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getAadharNumber() {
        return this.aadharNumber;
    }

    public void setAadharNumber(Long aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", aadharNumber='" + getAadharNumber() + "'" +
            ", fullname='" + getFullname() + "'" +
            ", gender='" + getGender() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", contact='" + getContact() + "'" +
            ", address='" + getAddress() + "'" +
            ", person='" + getPerson() + "'" +
            "}";
    }


}
