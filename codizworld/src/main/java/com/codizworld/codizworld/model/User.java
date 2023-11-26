package com.codizworld.codizworld.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "username is required")
    private String username; 

    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message="password is required")
    private String password;
    
    private Long contact; 
    private Date dob; 
    private String address; 

    public User() {
    }

    public User(Long userId, String username, String email, String password, Long contact, Date dob, String address) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.dob = dob;
        this.address = address;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getContact() {
        return this.contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", contact='" + getContact() + "'" +
            ", dob='" + getDob() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }



    
}
