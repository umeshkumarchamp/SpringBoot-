package com.codizworld.codizworld.controller.JpaMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codizworld.codizworld.model.springdatajpa.Book;
import com.codizworld.codizworld.service.BookService;


@RestController
public class BookController {

    @Autowired
    private BookService bookService; 

    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String test(){
        return "This is test message";
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> books = this.bookService.getAllBooks();
        if(books.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(books));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id){
        Book book = this.bookService.getBookById(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        try{
            Book b = bookService.addBook(book); 
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books/delete")
    public ResponseEntity<Book> removeBook(@RequestParam(name="id" , required = true) int boodId){
        try{
            Book b = bookService.removeBook(boodId);
            return new ResponseEntity<>(b,HttpStatus.ACCEPTED);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PutMapping("/books/update/{id}")
    public ResponseEntity<Book> updateBookById(@RequestBody Book book, @PathVariable("id") int bookId){
        try{
            Book b = bookService.updateBook(book, bookId);
            return ResponseEntity.ok().body(b);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
