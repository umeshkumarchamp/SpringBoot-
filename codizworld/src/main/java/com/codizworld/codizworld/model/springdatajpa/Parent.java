package com.codizworld.codizworld.model.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "parents")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String name; 
    private Long contact; 

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Child> children = new HashSet<Child>(); 

    public Parent() {
    }

    public Parent(Long id, String name, Long contact, Set<Child> children) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.children = children;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getContact() {
        return this.contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public Set<Child> getChildren() {
        return this.children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", contact='" + getContact() + "'" +
            ", children='" + getChildren() + "'" +
            "}";
    }


}
