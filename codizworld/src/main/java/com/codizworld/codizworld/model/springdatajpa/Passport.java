package com.codizworld.codizworld.model.springdatajpa;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "passports")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "passport_number", unique = true)
    private String passportNumber;

    @Column(name = "bearer_name")
    private String bearerName;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", unique = true)
    @JsonIgnore
    private Person person; 


    public Passport() {
    }

    public Passport(int id, String passportNumber, String bearerName, String placeOfBirth, LocalDate dob, Person person) {
        this.id = id;
        this.passportNumber = passportNumber;
        this.bearerName = bearerName;
        this.placeOfBirth = placeOfBirth;
        this.dob = dob;
        this.person = person;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBearerName() {
        return this.bearerName;
    }

    public void setBearerName(String bearerName) {
        this.bearerName = bearerName;
    }

    public String getPlaceOfBirth() {
        return this.placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPassportNumber() {
        return this.passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", passportNumber='" + getPassportNumber() + "'" +
            ", bearerName='" + getBearerName() + "'" +
            ", placeOfBirth='" + getPlaceOfBirth() + "'" +
            ", dob='" + getDob() + "'" +
            ", person='" + getPerson() + "'" +
            "}";
    }



}
