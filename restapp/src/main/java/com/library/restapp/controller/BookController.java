package com.library.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.restapp.model.Book;
import com.library.restapp.services.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService; 

    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String test(){
        return "This is test message";
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id){
        return this.bookService.getBookById(id);
    }

    @PostMapping("/books/add")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);        
    }

    @DeleteMapping("/books/delete")
    public Book removeBook(@RequestParam(name="id" , required = true) int boodId){
        return bookService.removeBook(boodId);
    }

}
