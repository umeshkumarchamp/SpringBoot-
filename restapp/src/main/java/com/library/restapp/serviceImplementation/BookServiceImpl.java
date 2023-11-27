package com.library.restapp.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.restapp.model.Book;
import com.library.restapp.repository.BookRepository;
import com.library.restapp.services.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepo;

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        bookRepo.save(book);
        return book;
    }

    @Override
    public Book removeBook(int bookId) {
        Book book = bookRepo.findById(bookId).orElse(null);
        bookRepo.delete(book);
        return book;
    }

    @Override
    public Book updateBook(Book updatedBook, int bookId) {
        
        Optional<Book> bookOptional = bookRepo.findById(bookId);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setAuthor(updatedBook.getAuthor());
            book.setBookTitle(updatedBook.getBookTitle());
            book.setPrice(updatedBook.getPrice());
            bookRepo.save(book);
            return book;
        }
        return null;
    }

}
