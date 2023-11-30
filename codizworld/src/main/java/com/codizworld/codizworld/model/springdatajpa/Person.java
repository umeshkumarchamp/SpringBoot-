package com.codizworld.codizworld.model.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    @Column(name = "full_name")
    private String fullname; 

    private Long contact;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Passport passport;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Aadhar aadhar; 

    @OneToMany(mappedBy = "accountHolder",cascade = CascadeType.ALL)
    private Set<BankAccount> bankAccounts = new HashSet<>();

    public Person() {
    }


    public Person(int id, String fullname, Long contact, Passport passport, Aadhar aadhar, Set<BankAccount> bankAccounts) {
        this.id = id;
        this.fullname = fullname;
        this.contact = contact;
        this.passport = passport;
        this.aadhar = aadhar;
        this.bankAccounts = bankAccounts;
    }
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Passport getPassport() {
        return this.passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Aadhar getAadhar() {
        return this.aadhar;
    }

    public void setAadhar(Aadhar aadhar) {
        this.aadhar = aadhar;
    }

    public Set<BankAccount> getBankAccounts() {
        return this.bankAccounts;
    }

    public void setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fullname='" + getFullname() + "'" +
            ", contact='" + getContact() + "'" +
            ", passport='" + getPassport() + "'" +
            ", aadhar='" + getAadhar() + "'" +
            ", bankAccounts='" + getBankAccounts() + "'" +
            "}";
    }



}
