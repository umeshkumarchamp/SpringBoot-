package com.springmvc.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.web.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
