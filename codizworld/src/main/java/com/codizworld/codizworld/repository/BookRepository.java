package com.codizworld.codizworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codizworld.codizworld.model.springdatajpa.Book;


public interface BookRepository extends JpaRepository<Book, Integer>{
    
}
