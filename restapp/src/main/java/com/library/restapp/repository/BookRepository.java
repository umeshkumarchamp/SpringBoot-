package com.library.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.restapp.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
    
}
