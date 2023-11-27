package com.library.restapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.library.restapp.model.Book;

@Service
public class BookService {
    private static List<Book> bookList = new ArrayList<>();

    static{
        bookList.add(new Book(2356, "Java the complete references", "James Goslin", 700.98F));
        bookList.add(new Book(7835, "Python the complete references", "James Goslin", 400.98F));
        bookList.add(new Book(2836, "JavaScript the complete references", "James Goslin", 900.98F));        
    }

    public List<Book> getAllBooks(){
        return bookList;
    }

    public Book getBookById(int id){
        Book book = null; 
        book = bookList.stream().filter(e->e.getBookId()==id).findFirst().get();
        return book;
    }   

    public Book addBook(Book book){
        bookList.add(book);
        return book;
    }

    public Book removeBook(int boodId){
        Book book = null; 
        book = bookList.stream().filter(e->e.getBookId()==boodId).findFirst().get();
        bookList.remove(book);
        return book;
    }
}