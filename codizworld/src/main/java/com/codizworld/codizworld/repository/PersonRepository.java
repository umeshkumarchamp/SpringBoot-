package com.codizworld.codizworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codizworld.codizworld.model.springdatajpa.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
    
}
