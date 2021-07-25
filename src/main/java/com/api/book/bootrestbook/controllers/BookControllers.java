package com.api.book.bootrestbook.controllers;

import java.util.List;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControllers 
{
    @Autowired
    private BookService bookService;
 
    @GetMapping("/books")
    public List<Book> getBooks()
    {       
        List<Book> allboBooks = this.bookService.getAllboBooks(); 
        return allboBooks;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int id)
    {
        Book bookById = this.bookService.getBookById(id);
        return bookById;

    }
    
}
