package com.codizworld.codizworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codizworld.codizworld.model.springdatajpa.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long>{
    
}
